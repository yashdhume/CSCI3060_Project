
#include "../Headers/Authenticator.h"

Authenticator::Authenticator(AccountDatabase &accountDatabase) : accountDatabase(accountDatabase) {}

//In future, this function would accept a username/password combo and validate the password before returning
//however since you can login without a password at the moment, this function can simply return the matching account directly from the database
Account* Authenticator::login(const std::string& username) {
    return accountDatabase.findAccountByUsername(username);
}
