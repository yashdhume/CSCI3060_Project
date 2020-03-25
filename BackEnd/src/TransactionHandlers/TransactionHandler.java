package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;
//Chain of responsibility
//Array of handlers with all false except for the correct handler
public interface TransactionHandler {

    TransactionType getTransactionType();
    String getName();
    boolean handleTransaction(Transaction transaction);
}
