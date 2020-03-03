#ifndef PHASE3_AUTHENTICATOR_H
#define PHASE3_AUTHENTICATOR_H

#include "SessionHandler.h"
#include "AccountDatabase.h"

//This class is only for authenticating credentials
//In future, this should be hooked up to the backend to validate a login
class Authenticator {
private:
    AccountDatabase &accountDatabase;

public:
    Authenticator(AccountDatabase &accountDatabase);

    //returns null if login failed for any reason
    //returns the account associated with the credentials if login succeeded
    Account* login(const std::string& username);
};

#endif //PHASE3_AUTHENTICATOR_H
