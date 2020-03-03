#ifndef PHASE3_TRANSACTION_H
#define PHASE3_TRANSACTION_H

#include <iostream>
#include <string>

//Stores a single transaction. These transactions are written to an output file at the end of a session
class Transaction {
public:
    //converts the transaction to a formatted string
    virtual std::string toString() = 0;
};

#endif //PHASE3_TRANSACTION_H
