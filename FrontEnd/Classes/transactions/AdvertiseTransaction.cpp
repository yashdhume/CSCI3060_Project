
#include "../../Headers/transactions/AdvertiseTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

AdvertiseTransaction::AdvertiseTransaction(Account sellerAccount, Item item)
        : sellerAccount(std::move(sellerAccount)), item(std::move(item)) {}

std::string AdvertiseTransaction::toString() {
    return "03 "+IOHelper::leftJustify(item.name,' ', 19)+" "+IOHelper::leftJustify(sellerAccount.username, ' ', 15)+" "+IOHelper::leftJustify(std::to_string((int)item.daysLeft), ' ', 3)+" "+IOHelper::leftJustify(std::to_string((int)item.currentBid), ' ', 6);
}
