package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class BidHandler extends BasicHandler {
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.BID;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        return false;
    }
}
