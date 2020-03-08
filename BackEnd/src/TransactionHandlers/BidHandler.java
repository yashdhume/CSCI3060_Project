package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class BidHandler implements TransactionHandler {
    @Override
    public int getAccountType() {
        return TransactionType.BID;
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
