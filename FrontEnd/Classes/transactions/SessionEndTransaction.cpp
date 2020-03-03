
#include "../../Headers/transactions/SessionEndTransaction.h"

#include <utility>

SessionEndTransaction::SessionEndTransaction(Account account) : account(std::move(account)) {}

std::string SessionEndTransaction::toString() {
    return "00 "+account.username+" "+account.accountType->getShortName()+" "+std::to_string((int)account.credit);
}
