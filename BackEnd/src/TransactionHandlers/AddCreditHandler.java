package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class AddCreditHandler extends BasicHandler{

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADD_CREDIT;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {

        return true;
    }

}
