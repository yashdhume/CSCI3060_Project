

#ifndef PHASE3_ADVERTISETRANSACTION_H
#define PHASE3_ADVERTISETRANSACTION_H
#include "Transaction.h"
#include "../Account.h"
#include "../Item.h"

class AdvertiseTransaction : public Transaction{
private:
    Account sellerAccount;
    Item item;
public:
    AdvertiseTransaction(Account sellerAccount, Item item);


    std::string toString() override;
};
#endif //PHASE3_ADVERTISETRANSACTION_H
