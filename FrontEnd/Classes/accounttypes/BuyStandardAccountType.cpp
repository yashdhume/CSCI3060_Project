
#include "../../Headers/accounttypes/BuyStandardAccountType.h"

std::string BuyStandardAccountType::getName() { return "BuyStandard"; }
std::string BuyStandardAccountType::getShortName() { return "BS"; }

bool BuyStandardAccountType::canBuy() { return true; }
bool BuyStandardAccountType::canSell() { return false; }
bool BuyStandardAccountType::hasAdminAccess() { return false; }