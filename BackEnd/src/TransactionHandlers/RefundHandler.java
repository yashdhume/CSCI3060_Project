package TransactionHandlers;

import Transaction.Transaction;
import Transaction.TransactionType;

public class RefundHandler extends BasicHandler {
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.REFUND;
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
