package Transaction;

public class Transaction {
    private TransactionType transactionType;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
