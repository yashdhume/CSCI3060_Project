package Transaction;

import Account.AccountType;

public class EndSessionTransaction extends Transaction{
    private TransactionType transactionType;
    private String username;
    private AccountType accountType;
    private double availableCredit;

    public EndSessionTransaction(TransactionType transactionType, String username, AccountType accountType, double availableCredit) {
        super(transactionType);
        this.username = username;
        this.accountType = accountType;
        this.availableCredit = availableCredit;
    }

    @Override
    public String toString() {
        return "EndSessionTransaction{" +
                "transactionType=" + transactionType +
                ", username='" + username + '\'' +
                ", accountType=" + accountType +
                ", availableCredit=" + availableCredit +
                '}';
    }
}
