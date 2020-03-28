
#include "../../Headers/transactions/RefundTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

RefundTransaction::RefundTransaction(Account buyerAccount, Account sellerAccount, double credit) : buyerAccount(std::move(buyerAccount)), sellerAccount(std::move(sellerAccount)), credit(credit) {}

std::string RefundTransaction::toString() {
    return "05 "+IOHelper::leftJustify(buyerAccount.username, ' ', 15)+" "+IOHelper::leftJustify(sellerAccount.username, ' ', 15)+" "+IOHelper::leftJustify(std::to_string((int)credit), ' ', 9);
}
