package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class CreateHandler implements TransactionHandler{
    @Override
    public int getAccountType() {
        return TransactionType.CREATE;
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
