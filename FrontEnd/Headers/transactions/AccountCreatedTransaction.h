#ifndef PHASE3_ACCOUNTCREATEDTRANSACTION_H
#define PHASE3_ACCOUNTCREATEDTRANSACTION_H

#include "Transaction.h"
#include "../Account.h"

class AccountCreatedTransaction : public Transaction{
private:
    Account account;
public:
    AccountCreatedTransaction(Account account);

    std::string toString() override;
};

#endif //PHASE3_ACCOUNTCREATEDTRANSACTION_H
