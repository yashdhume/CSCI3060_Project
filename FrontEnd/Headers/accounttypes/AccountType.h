#ifndef PHASE3_ACCOUNTTYPE_H
#define PHASE3_ACCOUNTTYPE_H

#include <iostream>
#include <fstream>

//Stores the "type" of the account
//This object controls the permission and actions that the account is allowed to perform
class AccountType {
public:

    virtual std::string getName() = 0;
    virtual std::string getShortName() = 0;

    //these functions control the permissions of the account
    virtual bool canBuy() = 0;
    virtual bool canSell() = 0;
    virtual bool hasAdminAccess() = 0;

    //create accountType from string
    static AccountType* fromString(const std::string& typeName);
    static AccountType* fromUser();
};

#endif //PHASE3_ACCOUNTTYPE_H
