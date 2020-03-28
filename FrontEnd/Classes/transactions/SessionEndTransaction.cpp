
#include "../../Headers/transactions/SessionEndTransaction.h"
#include "../../Headers/IOHelper.h"

#include <utility>

SessionEndTransaction::SessionEndTransaction(Account account) : account(std::move(account)) {}

std::string SessionEndTransaction::toString() {
    return "00 "+IOHelper::leftJustify(account.username, ' ', 15)+" "+account.accountType->getShortName()+" "+IOHelper::leftJustify(std::to_string((int)account.credit), ' ', 9);

}
