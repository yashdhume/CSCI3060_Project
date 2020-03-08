package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class AddCreditHandler implements TransactionHandler{

    @Override
    public int getType() {
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
