
#include "../../Headers/services/SalesService.h"
#include "../../Headers/transactions/AdvertiseTransaction.h"
#include "../../Headers/transactions/BidTransaction.h"

SalesService::SalesService(SessionHandler &sessionHandler, ItemDatabase &itemDatabase) : sessionHandler(sessionHandler), itemDatabase(itemDatabase){}

void SalesService::advertise() {
    //if the user is logged out or does not have sell access, reject the command
    if(sessionHandler.isLoggedOut() || !sessionHandler.getCurrentAccount()->accountType->canSell()){
        std::cout << "Must be logged into an account with permission to advertise" << std::endl;
        return;
    }

    Item item;

    item.sellerUsername = sessionHandler.getCurrentAccount()->username;
    item.highestBidderUsername = "";

    //the following code initializes all field of the item one by one
    //if any input is invalid, the item is discarded and the transaction fails

    std::cout << "Enter the name of the item" << std::endl;
    std::cin >> item.name;

    if(item.name.size() > 25){
        std::cout << "Advert failed. Item name cannot be more than 25 characters" << std::endl;
        return;
    }

    std::cout << "Enter the minimum bid" << std::endl;
    std::cin >> item.currentBid;

    if(item.currentBid > 999.99){
        std::cout << "Advert failed. Maximum bid cannot be more than 999.99" << std::endl;
        return;
    }

    std::cout << "Enter the duration of the auction (in days)" << std::endl;
    std::cin >> item.daysLeft;

    if(item.daysLeft > 100){
        std::cout << "Advert failed. Auction duration cannot be longer than 100 days" << std::endl;
        return;
    }

    //add the item to the database
    itemDatabase.items.push_back(item);
    itemDatabase.save();

    //record the transaction
    sessionHandler.addTransaction(new AdvertiseTransaction(*sessionHandler.getCurrentAccount(), item));

    std::cout << "Item advertised successfully" << std::endl;
}

void SalesService::bid() {
    //if the user is logged out or does not have buy access, reject the command
    if(sessionHandler.isLoggedOut() || !sessionHandler.getCurrentAccount()->accountType->canBuy()){
        std::cout << "Must be logged in with an account that has permission to place a bid" << std::endl;
        return;
    }

    //grab input
    std::string sellerUsername;
    std::string itemName;

    std::cout << "Enter the name of the item" << std::endl;
    std::cin >> itemName;

    std::cout << "Enter the username of the seller" << std::endl;
    std::cin >> sellerUsername;

    //if the item does not exist, the command fails
    Item *item = itemDatabase.findItem(sellerUsername, itemName);
    if(item == nullptr){
        std::cout << "Item does not exist" << std::endl;
        return;
    }

    double newBid;

    //display the current bid on the item
    std::cout << "Item found. Current highest bid is $" << item->currentBid << std::endl;

    std::cout << "Enter a new bid" << std::endl;
    std::cin >> newBid;

    //if the bid is lower than the current bid, reject the bid
    if(newBid <= item->currentBid){
        std::cout << "Bid failed. New bid must be greater than the current bid" << std::endl;
        return;
    }

    //if the account does not have admin access, check that the bid is atleast 5% more than the current bid
    if(!sessionHandler.getCurrentAccount()->accountType->hasAdminAccess()){
        if(newBid < item->currentBid*1.05){
            std::cout << "Bid failed. New bid must be at least 5% more than the current bid" << std::endl;
            return;
        }
    }

    //update the item bid
    item->currentBid = newBid;
    item->highestBidderUsername = sessionHandler.getCurrentAccount()->username;
    itemDatabase.save();

    //record the transaction
    sessionHandler.addTransaction(new BidTransaction(item->sellerUsername, *sessionHandler.getCurrentAccount(), *item));

    std::cout << "Successfully placed a bid on the item" << std::endl;
}
