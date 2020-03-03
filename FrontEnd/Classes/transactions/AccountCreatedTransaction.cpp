
#include "../../Headers/transactions/AccountCreatedTransaction.h"

#include <utility>

AccountCreatedTransaction::AccountCreatedTransaction(Account account) : account(std::move(account)) {}

std::string AccountCreatedTransaction::toString() {
    return "01 "+account.username+" "+account.accountType->getShortName()+" "+std::to_string((int)account.credit);
}
