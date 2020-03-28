package Transaction;

import Account.AccountType;
import Utilities.StringManipulation;

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

    @Override
    public String toString() {
        //XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        StringManipulation sm = new StringManipulation();
        return TransactionType.CREATE.getAccountTypeCode() +
                " " + username +
                " " + accountType +
                " " + sm.availableCreditFormatted(availableCredit);
    }
}
