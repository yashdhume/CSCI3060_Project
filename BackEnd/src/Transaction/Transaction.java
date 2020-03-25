package Transaction;

import Account.AccountType;

public class Transaction {
    private TransactionType transactionType;
    private String username;
    private AccountType accountType;
    private double availableCredit;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction(TransactionType transactionType, String username,
                       AccountType accountType, double availableCredit) {
        this.transactionType = transactionType;
        this.username = username;
        this.accountType = accountType;
        this.availableCredit = availableCredit;
    }
}
