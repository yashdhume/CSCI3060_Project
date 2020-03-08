package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class RefundHandler implements TransactionHandler{
    @Override
    public int getAccountType() {
        return TransactionType.REFUND;
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
