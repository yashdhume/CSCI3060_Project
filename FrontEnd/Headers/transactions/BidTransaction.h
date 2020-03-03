
#ifndef PHASE3_BIDTRANSACTION_H
#define PHASE3_BIDTRANSACTION_H
#include "Transaction.h"
#include "../Account.h"
#include "../Item.h"

class BidTransaction : public Transaction{
private:
    std::string sellerUsername;
    Account buyerAccount;
    Item item;
public:

    BidTransaction(std::string sellerUsername, Account buyerAccount, Item item);

    std::string toString() override;
};
#endif //PHASE3_BIDTRANSACTION_H
