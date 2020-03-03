#ifndef PHASE3_ACCOUNT_H
#define PHASE3_ACCOUNT_H

#include "accounttypes/AccountType.h"

//Stores all the details of an account
class Account {
public:
    Account();

    Account(std::string username, AccountType *accountType, double credit);

    std::string username;
    AccountType *accountType = nullptr; //the type of account (should not be null after initialization)
    double credit = 0;

    void readFromFile(std::ifstream &fin);
    void writeToFile(std::ofstream &fout);
};

#endif //PHASE3_ACCOUNT_H
