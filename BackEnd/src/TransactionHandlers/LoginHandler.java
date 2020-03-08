package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class LoginHandler implements TransactionHandler {
    @Override
    public int getAccountType() {
        return TransactionType.LOGIN;
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
