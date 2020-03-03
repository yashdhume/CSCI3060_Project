
#include "../../Headers/transactions/CreditAddedTransaction.h"

#include <utility>

CreditAddedTransaction::CreditAddedTransaction(Account account, double credit) : account(std::move(account)), credit(credit) {}

std::string CreditAddedTransaction::toString() {
    return "06 "+account.username+" "+account.accountType->getShortName()+" "+std::to_string((int)credit);
}
