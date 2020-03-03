#ifndef PHASE3_BUYSTANDARDACCOUNTTYPE_H
#define PHASE3_BUYSTANDARDACCOUNTTYPE_H

#include "AccountType.h"

//child class of AccountType. Gives buy access
class BuyStandardAccountType : public AccountType{
public:
    std::string getName() override;

    bool canBuy() override;

    bool canSell() override;

    bool hasAdminAccess() override;

    std::string getShortName() override;
};

#endif //PHASE3_BUYSTANDARDACCOUNTTYPE_H
