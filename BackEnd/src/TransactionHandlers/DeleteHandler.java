package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class DeleteHandler extends BasicHandler {
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.DELETE;
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
