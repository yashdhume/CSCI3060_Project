#ifndef PHASE3_SIGNINSERVICE_H
#define PHASE3_SIGNINSERVICE_H

#include "../SessionHandler.h"
#include "../Authenticator.h"

//This class is the endpoint for logging in and logging out
//Makes sure the session is started/ended, also validates the credentials with the auth service
class SignInService {
private:
    Authenticator &authenticationService;
    SessionHandler &sessionHandler;

public:
    SignInService(Authenticator &authenticationService, SessionHandler &sessionHandler);

    void login();
    void logout();
};

#endif //PHASE3_SIGNINSERVICE_H
