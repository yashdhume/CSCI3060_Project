
#include "../../Headers/transactions/AccountDeletedTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

AccountDeletedTransaction::AccountDeletedTransaction(Account account) : account(std::move(account)) {}

std::string AccountDeletedTransaction::toString() {
    return "02 "+IOHelper::leftJustify(account.username, ' ', 15)+" "+account.accountType->getShortName()+" "+IOHelper::rightJustify(std::to_string((int)account.credit), '0', 9);
}
