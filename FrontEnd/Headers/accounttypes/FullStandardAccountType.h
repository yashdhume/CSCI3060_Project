
#ifndef PHASE3_FULLSTANDARDACCOUNTTYPE_H
#define PHASE3_FULLSTANDARDACCOUNTTYPE_H

#include "AccountType.h"

//child class of AccountType. Gives full buy/sell access
class FullStandardAccountType : public AccountType {
public:
    std::string getName() override;

    bool canBuy() override;

    bool canSell() override;

    bool hasAdminAccess() override;

    std::string getShortName() override;
};

#endif //PHASE3_FULLSTANDARDACCOUNTTYPE_H
