
#include "../../Headers/transactions/AccountCreatedTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

AccountCreatedTransaction::AccountCreatedTransaction(Account account) : account(std::move(account)) {}

std::string AccountCreatedTransaction::toString() {
    return "01 "+IOHelper::leftJustify(account.username, ' ', 15)+" "+account.accountType->getShortName()+" "+IOHelper::leftJustify(std::to_string((int)account.credit), ' ', 9);
}
