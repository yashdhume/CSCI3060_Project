
#include "../../Headers/transactions/AccountDeletedTransaction.h"

#include <utility>

AccountDeletedTransaction::AccountDeletedTransaction(Account account) : account(std::move(account)) {}

std::string AccountDeletedTransaction::toString() {
    return "02 "+account.username+" "+account.accountType->getShortName()+" "+std::to_string((int)account.credit);
}
