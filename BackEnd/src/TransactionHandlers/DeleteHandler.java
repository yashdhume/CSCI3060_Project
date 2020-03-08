package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class DeleteHandler implements TransactionHandler{
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.DELETE;
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
