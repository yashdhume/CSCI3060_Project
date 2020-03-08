package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class LogoutHandler implements TransactionHandler {
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.LOGOUT;
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
