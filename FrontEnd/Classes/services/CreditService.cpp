
#include "../../Headers/services/CreditService.h"
#include "../../Headers/transactions/RefundTransaction.h"
#include "../../Headers/transactions/CreditAddedTransaction.h"

#include <utility>

CreditService::CreditService(AccountDatabase &accountDatabase, SessionHandler &sessionHandler) : accountDatabase(accountDatabase), sessionHandler(sessionHandler) {}

void CreditService::refund() {
    //if the user is logged out or does not have sell access, reject the command
    if(sessionHandler.isLoggedOut() || !sessionHandler.getCurrentAccount()->accountType->canSell()){
        std::cout << "Must be logged in as an admin to issue a refund" << std::endl;
        return;
    }

    //grab input
    std::string buyerUsername;
    std::string sellerUsername;

    std::cout << "Enter the username of the buyer" << std::endl;
    std::cin >> buyerUsername;

    //if the buyer does not exist, reject the command
    Account *buyer = accountDatabase.findAccountByUsername(buyerUsername);
    if(buyer == nullptr){
        std::cout << "Refund failed. Buyer account does not exist" << std::endl;
        return;
    }

    //grab input
    std::cout << "Enter the username of the seller" << std::endl;
    std::cin >> sellerUsername;

    //if the seller does not exist, reject the command
    Account *seller = accountDatabase.findAccountByUsername(sellerUsername);
    if(seller == nullptr){
        std::cout << "Refund failed. Seller account does not exist" << std::endl;
        return;
    }

    double credit;

    //grab input
    std::cout << "Enter the amount of credit to refund" << std::endl;
    std::cin >> credit;

    //transfer the credit
    seller->credit -= credit;
    buyer->credit += credit;
    accountDatabase.save();

    //record the transaction
    sessionHandler.addTransaction(new RefundTransaction(*buyer, *seller, credit));

    std::cout << "Refund completed successfully" << std::endl;
}

void CreditService::addCredit() {
    //if the user is logged out, reject the command
    if(sessionHandler.isLoggedOut()){
        std::cout << "Must be logged in to add credit" << std::endl;
        return;
    }

    double credit;

    //grab input
    std::cout << "Enter the amount of credit to add" << std::endl;
    std::cin >> credit;

    if(credit > 1000){
        std::cout << "Add credit failed. Must be less than 1000 credits" << std::endl;
        return;
    }

    Account *account = sessionHandler.getCurrentAccount();

    //if the current account has admin access, it gets to pick a user
    if(sessionHandler.getCurrentAccount()->accountType->hasAdminAccess()) {
        std::string username;

        std::cout << "Enter the username of the target account" << std::endl;
        std::cin >> username;

        account = accountDatabase.findAccountByUsername(username);

        //if the account does not exist, the addcredit fails
        if (account == nullptr) {
            std::cout << "Add credit failed. account does not exist" << std::endl;
            return;
        }
    }

    //add the credit to the account
    account->credit += credit;
    accountDatabase.save();

    //record the transaction
    sessionHandler.addTransaction(new CreditAddedTransaction(*account, credit));

    std::cout << "Credit added successfully" << std::endl;
}
