package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class AdvertiseHandler extends BasicHandler{
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADVERTISE;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean transactionChecker(Transaction transaction) {
        if(!checkType(transaction)){ return false; }

        /*

         */

        return false;
    }
}
