package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class CreateHandler extends BasicHandler{
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.CREATE;
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
