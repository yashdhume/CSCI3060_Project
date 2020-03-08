package TransactionHandlers;

import Transaction.Transaction;

public interface TransactionHandler {
    int getAccountType();
    String getName();
    boolean transactionChecker(Transaction transaction);
}
