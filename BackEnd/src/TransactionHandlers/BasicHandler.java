package TransactionHandlers;

import Transaction.Transaction;

public abstract class BasicHandler implements TransactionHandler{

    public boolean checkType(Transaction transaction) {
        return transaction.getTransactionType() == getTransactionType();
    }
}
