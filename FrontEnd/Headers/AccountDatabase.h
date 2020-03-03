
#ifndef PHASE3_ACCOUNTDATABASE_H
#define PHASE3_ACCOUNTDATABASE_H

#include <iostream>
#include <fstream>
#include <vector>
#include "Account.h"

//stores a database of all accounts
class AccountDatabase {
public:
    //the commandline argument passed for the accounts data file
    AccountDatabase(std::string dataFile);

    std::string dataFile;
    std::vector<Account> accounts;

    //returns null if the account could not be found
    Account* findAccountByUsername(const std::string& username);

    void readFromFile(std::ifstream &fin);
    void writeToFile(std::ofstream &fout);

    //ease of use functions, call read/write automatically with the dataFile
    void load();
    void save();
};


#endif //PHASE3_ACCOUNTDATABASE_H
