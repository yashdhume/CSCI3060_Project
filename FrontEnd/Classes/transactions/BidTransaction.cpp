
#include "../../Headers/transactions/BidTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

BidTransaction::BidTransaction(std::string sellerUsername, Account buyerAccount, Item item) : sellerUsername(std::move(sellerUsername)), buyerAccount(std::move(buyerAccount)), item(std::move(item)) {}

std::string BidTransaction::toString() {
    return "04 " + IOHelper::leftJustify(item.name,' ', 19) + " " + IOHelper::leftJustify(sellerUsername, ' ', 15) + " " + IOHelper::leftJustify(buyerAccount.username, ' ', 15) + IOHelper::leftJustify(std::to_string((int)item.currentBid), ' ', 6);
}