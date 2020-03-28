
#include "../../Headers/transactions/CreditAddedTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

CreditAddedTransaction::CreditAddedTransaction(Account account, double credit) : account(std::move(account)), credit(credit) {}

std::string CreditAddedTransaction::toString() {
    return "06 "+IOHelper::leftJustify(account.username, ' ', 15)+" "+account.accountType->getShortName()+" "+IOHelper::leftJustify(std::to_string((int)account.credit), ' ', 9);
}
