
#ifndef PHASE3_REFUNDTRANSACTION_H
#define PHASE3_REFUNDTRANSACTION_H
#include "Transaction.h"
#include "../Account.h"
class RefundTransaction : public Transaction{
private:
    Account buyerAccount;
    Account sellerAccount;
    double credit;

public:
    RefundTransaction(Account buyerAccount, Account sellerAccount, double credit);

    std::string toString() override;
};
#endif //PHASE3_REFUNDTRANSACTION_H
