package Transaction;

import Account.AccountType;

public class SessionEndTransaction extends Transaction{
    private String username;
    private AccountType accountType;
    private double availableCredit;

    public SessionEndTransaction(String username, AccountType accountType, double availableCredit) {
        super(TransactionType.SESSION_END);
        this.username = username;
        this.accountType = accountType;
        this.availableCredit = availableCredit;
    }

    @Override
    public String toString() {
        return "EndSessionTransaction{" +
                "username='" + username + '\'' +
                ", accountType=" + accountType +
                ", availableCredit=" + availableCredit +
                '}';
    }
}
