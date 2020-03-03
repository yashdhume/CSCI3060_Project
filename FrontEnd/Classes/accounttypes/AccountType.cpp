
#include "../../Headers/accounttypes/AccountType.h"
#include "../../Headers/accounttypes/AdminAccountType.h"
#include "../../Headers/accounttypes/BuyStandardAccountType.h"
#include "../../Headers/accounttypes/FullStandardAccountType.h"
#include "../../Headers/accounttypes/SellStandardAccountType.h"

AccountType *AccountType::fromString(const std::string& typeName) {
    //a list of all account types
    AccountType *accountTypes[] = {new AdminAccountType(), new BuyStandardAccountType(),
                                   new FullStandardAccountType(), new SellStandardAccountType()};

    //return the matching account type
    for(auto & accountType : accountTypes){
        if(accountType->getShortName() == typeName){
            return accountType;
        }
    }

    //if none of the account types match, return null
    return nullptr;
}

AccountType *AccountType::fromUser() {
    AccountType *accountTypes[] = {new AdminAccountType(), new BuyStandardAccountType(),
                                   new FullStandardAccountType(), new SellStandardAccountType()};

    //get the account name from the user
    std::string typeName;
    std::cout << "Enter the type of account" << std::endl;
    std::cin >> typeName;

    //return the matching account type
    for(auto & accountType : accountTypes){
        if(accountType->getName() == typeName){
            return accountType;
        }
    }

    //if none of the account types match, return null

    std::cout << "Invalid account type. Must be one of the following:";
    for(auto & accountType : accountTypes){
        std::cout << " " << accountType->getName();
    }
    std::cout << std::endl;

    return nullptr;
}


