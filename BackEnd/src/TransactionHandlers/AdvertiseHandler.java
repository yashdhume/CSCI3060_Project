package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class AdvertiseHandler implements TransactionHandler{
    @Override
    public int getAccountType() {
        return TransactionType.ADD_CREDIT;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean transactionChecker(Transaction transaction) {
        return false;
    }
}
