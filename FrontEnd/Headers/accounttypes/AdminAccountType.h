#ifndef PHASE3_ADMINACCOUNTTYPE_H
#define PHASE3_ADMINACCOUNTTYPE_H

#include "AccountType.h"

//child class of AccountType. Gives full admin access
class AdminAccountType : public AccountType{
public:
    std::string getName() override;

    bool canBuy() override;

    bool canSell() override;

    bool hasAdminAccess() override;

    std::string getShortName() override;
};

#endif //PHASE3_ADMINACCOUNTTYPE_H
