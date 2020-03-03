
#ifndef PHASE3_SESSIONENDTRANSACTION_H
#define PHASE3_SESSIONENDTRANSACTION_H
#include "Transaction.h"
#include "../Account.h"
class SessionEndTransaction : public Transaction{
private:
    Account account;
public:
    SessionEndTransaction(Account account);

    std::string toString() override;
};
#endif //PHASE3_SESSIONENDTRANSACTION_H
