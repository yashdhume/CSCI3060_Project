package TransactionHandlers;

import Transaction.Transaction;

public interface TransactionHandler {
    int getType();
    String getName();
    boolean transactionChecker(Transaction transaction);
}
