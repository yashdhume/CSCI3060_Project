
#include "../../Headers/transactions/RefundTransaction.h"

#include <utility>

RefundTransaction::RefundTransaction(Account buyerAccount, Account sellerAccount, double credit) : buyerAccount(std::move(buyerAccount)), sellerAccount(std::move(sellerAccount)), credit(credit) {}

std::string RefundTransaction::toString() {
    return "05 "+buyerAccount.username+" "+sellerAccount.username+" "+std::to_string((int)credit);
}
