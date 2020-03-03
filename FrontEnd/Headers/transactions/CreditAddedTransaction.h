
#ifndef PHASE3_CREDITADDEDTRANSACTION_H
#define PHASE3_CREDITADDEDTRANSACTION_H
#include "Transaction.h"
#include "../Account.h"

class CreditAddedTransaction : public Transaction{
private:
    Account account;
    double credit;

public:
    CreditAddedTransaction(Account account, double credit);

    std::string toString() override;
};
#endif //PHASE3_CREDITADDEDTRANSACTION_H
