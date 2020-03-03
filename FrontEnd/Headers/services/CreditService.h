
#ifndef PHASE3_CREDITSERVICE_H
#define PHASE3_CREDITSERVICE_H

#include "../AccountDatabase.h"
#include "../SessionHandler.h"

//This class is an endpoint. User for manipulating credits on user accounts
class CreditService {
private:
    AccountDatabase &accountDatabase;
    SessionHandler &sessionHandler;

public:
    CreditService(AccountDatabase& accountDatabase,SessionHandler& sessionHandler);

    void refund();
    void addCredit();
};

#endif //PHASE3_CREDITSERVICE_H
