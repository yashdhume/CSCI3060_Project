
#include "../../Headers/accounttypes/AdminAccountType.h"

std::string AdminAccountType::getName() { return "Admin"; }
std::string AdminAccountType::getShortName() { return "AA"; }

bool AdminAccountType::canBuy() { return true; }
bool AdminAccountType::canSell() { return true; }
bool AdminAccountType::hasAdminAccess() { return true; }
