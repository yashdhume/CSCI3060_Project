package TransactionHandlers;

import Transaction.Transaction;

public class AddCreditHandler implements TransactionHandler{

    @Override
    public int getType() {
        return 0;
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
