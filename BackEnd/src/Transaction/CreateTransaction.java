package Transaction;

import Account.AccountType;
import Utilities.StringManipulation;

public class CreateTransaction extends Transaction{
    private String accountName;
    private AccountType accountType;
    private double accountCredits;

    public CreateTransaction(String accountName, AccountType accountType, double accountCredits) {
        super(TransactionType.CREATE);
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountCredits = accountCredits;
    }

    public String getAccountName() {
        return accountName;
    }
    public AccountType getAccountType(){
        return accountType;
    }


    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountCredits() {
        return accountCredits;
    }

    public void setAccountCredits(double accountCredits) {
        this.accountCredits = accountCredits;
    }

    @Override
    public String toString() {
        //XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        StringManipulation sm = new StringManipulation();
        return TransactionType.CREATE.getAccountTypeCode() +
                " " + accountName+
                " " + accountType +
                " " + sm.availableCreditFormatted(accountCredits);
    }
}
