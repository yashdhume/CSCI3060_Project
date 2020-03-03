
#include "../../Headers/services/AccountsService.h"

#include <utility>
#include <algorithm>
#include "../../Headers/accounttypes/BuyStandardAccountType.h"
#include "../../Headers/transactions/AccountCreatedTransaction.h"
#include "../../Headers/transactions/AccountDeletedTransaction.h"

AccountsService::AccountsService(AccountDatabase &accountDatabase, SessionHandler &sessionHandler) : accountDatabase(accountDatabase), sessionHandler(sessionHandler){}

void AccountsService::createAccount() {
    //if the user is logged out or does not have admin access, reject the command
    if(sessionHandler.isLoggedOut() || !sessionHandler.getCurrentAccount()->accountType->hasAdminAccess()){
        std::cout << "Must be logged in as an admin to create an account" << std::endl;
        return;
    }

    //grab input
    std::string username;
    std::cout << "Enter a username" << std::endl;
    std::cin >> username;

    //username is too long
    if(username.size() > 15){
        std::cout << "Create failed. Username must be less than 16 characters" << std::endl;
        return;
    }

    //fail when the new account already exists in the database
    Account *existingAccount = accountDatabase.findAccountByUsername(username);
    if(existingAccount != nullptr){
        std::cout << "Create account failed. User already exists" << std::endl;
        return;
    }

    //if the account type is invalid, the function fails (gracefully)
    AccountType *accountType = AccountType::fromUser();
    if(accountType == nullptr){
        std::cout << "Create account failed" << std::endl;
        return;
    }

    //add the account to the database
    Account account(username, accountType, 0.0);
    accountDatabase.accounts.push_back(account);
    accountDatabase.save();

    //record the transaction
    sessionHandler.addTransaction(new AccountCreatedTransaction(account));

    std::cout << "New account created successfully!" << std::endl;
}

void AccountsService::deleteAccount() {
    //if the user is logged out or does not have admin access, reject the command
    if (sessionHandler.isLoggedOut() || !sessionHandler.getCurrentAccount()->accountType->hasAdminAccess()) {
        std::cout << "Must be logged in as admin to delete an account" << std::endl;
        return;
    }

    //grab input
    std::string username;
    std::cout << "Enter a username" << std::endl;
    std::cin >> username;

    //admin cannot delete their own account
    if(username == sessionHandler.getCurrentAccount()->username){
        std::cout << "You cannot deleted your own account" << std::endl;
        return;
    }

    //if the account does not exist, it cannot be deleted
    Account *account = accountDatabase.findAccountByUsername(username);
    if (account == nullptr) {
        std::cout << "Account does not exist and cannot be deleted" << std::endl;
        return;
    }

    //record the transaction
    sessionHandler.addTransaction(new AccountDeletedTransaction(*account));

    //remove the account from the database
    for(int i = 0; i < accountDatabase.accounts.size(); i++){
        if(accountDatabase.accounts[i].username == account->username){
            accountDatabase.accounts.erase(accountDatabase.accounts.begin() + i);
            break;
        }
    }
    accountDatabase.save();

    std::cout << "Account deleted successfully" << std::endl;
}