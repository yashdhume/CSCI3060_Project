package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class LogoutHandler extends BasicHandler {
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.LOGOUT;
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
