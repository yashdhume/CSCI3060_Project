package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class AddCreditHandler implements TransactionHandler{

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADD_CREDIT;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean transactionChecker(Transaction transaction) {
        if(transaction.getTransactionType()!=getTransactionType()){
            return false;
        }
        return true;
    }

}
