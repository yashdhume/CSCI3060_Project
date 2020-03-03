
#include "../Headers/SessionHandler.h"
#include "../Headers/transactions/SessionEndTransaction.h"

#include <utility>

SessionHandler::SessionHandler(std::string transactionsFile) : transactionsFile(std::move(transactionsFile)) {}

void SessionHandler::startSession(Account *account) {
    //end any existing session
    if(!isLoggedOut()) endSession();

    //start the session
    currentAccount = account;
}

void SessionHandler::endSession() {
    //if the session is already terminated, nothing needs to be done
    if(isLoggedOut()) return;

    //record the end of the session transaction
    addTransaction(new SessionEndTransaction(*currentAccount));

    //reset the account
    currentAccount = nullptr;

    //output all transactions to the passed file name
    std::ofstream fout(transactionsFile);
    for(auto & transaction : transactions){
        fout << transaction->toString() << std::endl;
    }
    fout.close();
}

//helper function
bool SessionHandler::isLoggedOut() {
    return currentAccount == nullptr;
}

void SessionHandler::addTransaction(Transaction *transaction) {
    transactions.push_back(transaction);
}
