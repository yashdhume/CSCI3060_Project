
#include "../Headers/Account.h"
#include "../Headers/IOHelper.h"

#include <utility>

Account::Account() = default;

Account::Account(std::string username, AccountType *accountType, double credit) : username(std::move(username)), accountType(accountType), credit(credit) {}

void Account::readFromFile(std::ifstream &fin) {
    std::string line;
    getline(fin, line);

    //read the fields from the file
    username = IOHelper::trim(line.substr(0, 15));
    accountType = AccountType::fromString(IOHelper::trim(line.substr(16, 2)));
    try {
        credit = stoi(IOHelper::trim(line.substr(19, 9)));
    }
    catch (std::exception &e){}
}

void Account::writeToFile(std::ofstream &fout) {
    //write the fields to the file
    fout << IOHelper::leftJustify(username, ' ', 15) << ' ';
    fout << IOHelper::leftJustify(accountType->getShortName(), ' ', 2) << ' ';
    fout << IOHelper::leftJustify(std::to_string((int)credit), ' ', 9);
}

