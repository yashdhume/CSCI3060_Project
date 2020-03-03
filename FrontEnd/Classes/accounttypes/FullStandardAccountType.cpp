
#include "../../Headers/accounttypes/FullStandardAccountType.h"

std::string FullStandardAccountType::getName() { return "FullStandard"; }
std::string FullStandardAccountType::getShortName() { return "FS"; }

bool FullStandardAccountType::canBuy() { return true; }
bool FullStandardAccountType::canSell() { return true; }
bool FullStandardAccountType::hasAdminAccess() { return false; }