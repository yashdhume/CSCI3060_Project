
#include "../Headers/AccountDatabase.h"
#include "../Headers/IOHelper.h"

#include <utility>

AccountDatabase::AccountDatabase(std::string dataFile) : dataFile(std::move(dataFile)){}

void AccountDatabase::readFromFile(std::ifstream &fin) {
    //keep reading accounts until we reach the "end" line
    accounts.clear();
    while(true){
        Account account;
        account.readFromFile(fin);

        if(account.username == "END"){ break; }
        accounts.push_back(account);
    }
}

void AccountDatabase::writeToFile(std::ofstream &fout) {
    //write all accounts to file
    for(auto & account : accounts){
        account.writeToFile(fout);
        fout << std::endl;
    }
    //write an empty line with "end"
    fout << IOHelper::leftJustify("END", ' ', 28) << std::endl;
}

//call readFromFile with the command line passed file name
void AccountDatabase::load() {
    std::ifstream fin(dataFile);
    readFromFile(fin);
    fin.close();
}

//call writeToFile with the command line passed file name
void AccountDatabase::save() {
    std::ofstream fout(dataFile);
    writeToFile(fout);
    fout.close();
}

Account* AccountDatabase::findAccountByUsername(const std::string& username) {
    //find an account with a matching username
    for(auto & account : this->accounts){
        if(account.username == username){
            return &account;
        }
    }
    //return null if no accounts matched
    return nullptr;
}
