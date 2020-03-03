#ifndef PHASE3_SESSIONHANDLER_H
#define PHASE3_SESSIONHANDLER_H

#include <vector>
#include "Account.h"
#include "transactions/Transaction.h"

//Keeps track of the current session
//This class stores the current signed in account, as well as all transactions that occurred during the session
class SessionHandler {
private:
    Account *currentAccount = nullptr; //may be null if logged out
    std::vector<Transaction*> transactions; //all transactions in a single session
    std::string transactionsFile; //the command line argument pointing to the transaction file location

public:
    SessionHandler(std::string transactionsFile);

    bool isLoggedOut();

    //returns null if logged out
    Account *getCurrentAccount(){ return currentAccount; }

    void startSession(Account *account);
    void endSession();

    void addTransaction(Transaction *transaction);
};

#endif //PHASE3_SESSIONHANDLER_H
