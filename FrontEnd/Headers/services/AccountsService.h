#ifndef PHASE3_ACCOUNTSSERVICE_H
#define PHASE3_ACCOUNTSSERVICE_H

#include "../AccountDatabase.h"
#include "../SessionHandler.h"

//This class is an endpoint. User for manipulating the account database
class AccountsService {
private:
    AccountDatabase &accountDatabase;
    SessionHandler &sessionHandler;

public:
    AccountsService(AccountDatabase &accountDatabase, SessionHandler &sessionHandler);

    void createAccount();
    void deleteAccount();
};

#endif //PHASE3_ACCOUNTSSERVICE_H
