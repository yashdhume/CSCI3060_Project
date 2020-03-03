
#include "../../Headers/transactions/BidTransaction.h"

#include <utility>

BidTransaction::BidTransaction(std::string sellerUsername, Account buyerAccount, Item item) : sellerUsername(std::move(sellerUsername)), buyerAccount(std::move(buyerAccount)), item(std::move(item)) {}

std::string BidTransaction::toString() {
    return "04 " + item.name + " " + sellerUsername + " " + buyerAccount.username + " " + std::to_string((int)item.currentBid);
}