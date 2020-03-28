#include <iostream>
#include "Headers/SessionHandler.h"
#include "Headers/services/SignInService.h"
#include "Headers/ItemDatabase.h"
#include "Headers/AccountDatabase.h"
#include "Headers/services/AccountsService.h"
#include "Headers/services/SalesService.h"
#include "Headers/services/CreditService.h"

void processCommand(SignInService &signInService, AccountsService &accountsService, SalesService &salesService, CreditService &creditService){
    std::string command;

    std::cout << "Enter a command" << std::endl;
    std::cin >> command;

    if(command == "login"){
        signInService.login();
    }
    else if(command == "logout"){
        signInService.logout();
    }
    else if(command == "create"){
        accountsService.createAccount();
    }
    else if(command == "delete") {
        accountsService.deleteAccount();
    }
    else if(command=="advertise") {
        salesService.advertise();
    }
    else if(command=="bid"){
        salesService.bid();
    }
    else if(command=="refund"){
        creditService.refund();
    }
    else if(command=="addcredit"){
        creditService.addCredit();
    }
    else if (command=="exit"){
        exit(0);
    }
    else{
        std::cout << "Invalid command. Valid commands are: ";
        std::cout << "login ";
        std::cout << "logout ";
        std::cout << "create ";
        std::cout << "delete ";
        std::cout << "refund ";
        std::cout << "addcredit ";
        std::cout << "advertise ";
        std::cout << "bid ";
        std::cout << "exit" << std::endl;
    }
}

int main(int argc, char **argv){
    if(argc < 4){
        std::cout << "Not enough arguments (must be at-least 3)" << std::endl;
        return 0;
    }
    //database files
//    std::string accountsFile = "accounts.txt";
//    std::string itemsFile = "items.txt";
//    std::string transactionsFile = "transactions.txt";
    std::string accountsFile = argv[1];
    std::string itemsFile = argv[2];
    std::string transactionsFile = argv[3];

    //database connections
    AccountDatabase accountDatabase(accountsFile);
    ItemDatabase itemDatabase(itemsFile);

    accountDatabase.load();
    itemDatabase.load();

    //handlers / services
    SessionHandler sessionHandler(transactionsFile);
    Authenticator authenticator(accountDatabase);

    //endpoint services
    SignInService signInService(authenticator, sessionHandler);
    AccountsService accountsService(accountDatabase, sessionHandler);
    SalesService salesService(sessionHandler, itemDatabase);
    CreditService creditService(accountDatabase, sessionHandler);

    int c = 1;
    while(c++){
        processCommand(signInService, accountsService, salesService, creditService);
    }

    return 0;
};