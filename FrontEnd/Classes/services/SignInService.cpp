#include "../../Headers/services/SignInService.h"

SignInService::SignInService(Authenticator &authenticationService, SessionHandler &sessionHandler) : authenticationService(authenticationService), sessionHandler(sessionHandler){}

void SignInService::login() {
    //if the user is logged out, reject the command
    if(!sessionHandler.isLoggedOut()){
        std::cout << "You are already logged in!" << std::endl;
        return;
    }

    //grab input
    std::string username;
    std::cout << "Enter a username" << std::endl;
    std::cin >> username;

    //if the authentication failed, the account returned will be null which means login failed.
    Account *account = authenticationService.login(username);
    if(account == nullptr){
        std::cout << "Login failed, user does not exist" << std::endl;
        return;
    }

    //start the session with the account
    sessionHandler.startSession(account);
    std::cout << "Login Successful" << std::endl;
}

void SignInService::logout() {
    //cannot log out while logged out
    if(sessionHandler.isLoggedOut()){
        std::cout << "You are already logged out" << std::endl;
        return;
    }

    //end the session
    sessionHandler.endSession();
    std::cout << "Logout Successful" << std::endl;
}
