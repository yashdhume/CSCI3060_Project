
#include "../../Headers/transactions/AdvertiseTransaction.h"

#include <utility>

AdvertiseTransaction::AdvertiseTransaction(Account sellerAccount, Item item)
        : sellerAccount(std::move(sellerAccount)), item(std::move(item)) {}

std::string AdvertiseTransaction::toString() {
    return "03 "+item.name+" "+sellerAccount.username+" "+std::to_string((int)item.daysLeft)+" "+std::to_string((int)item.currentBid);
}
