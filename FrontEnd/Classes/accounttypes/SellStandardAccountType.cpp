
#include "../../Headers/accounttypes/SellStandardAccountType.h"

std::string SellStandardAccountType::getName() { return "SellStandard"; }
std::string SellStandardAccountType::getShortName() { return "SS"; }

bool SellStandardAccountType::canBuy() { return false; }
bool SellStandardAccountType::canSell() { return true; }
bool SellStandardAccountType::hasAdminAccess() { return false; }
