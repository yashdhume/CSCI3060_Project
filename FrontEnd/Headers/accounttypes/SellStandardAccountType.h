#ifndef PHASE3_SELLSTANDARDACCOUNTTYPE_H
#define PHASE3_SELLSTANDARDACCOUNTTYPE_H

#include "AccountType.h"

//child class of AccountType. Gives full admin access
class SellStandardAccountType : public AccountType{
public:
    std::string getName() override;

    bool canBuy() override;

    bool canSell() override;

    bool hasAdminAccess() override;

    std::string getShortName() override;
};

#endif //PHASE3_SELLSTANDARDACCOUNTTYPE_H
