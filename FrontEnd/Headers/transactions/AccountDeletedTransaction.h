#ifndef PHASE3_ACCOUNTDELETEDTRANSACTION_H
#define PHASE3_ACCOUNTDELETEDTRANSACTION_H
#include "Transaction.h"
#include "../Account.h"

class AccountDeletedTransaction : public Transaction{
private:
    Account account;
public:
    AccountDeletedTransaction(Account account);

    std::string toString() override;
};

#endif //PHASE3_ACCOUNTDELETEDTRANSACTION_H
