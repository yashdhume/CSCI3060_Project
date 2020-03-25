package Account;

import StringManipulation.StringJustifies;

public class Account {
    private String accountName;
    private AccountType accountType;
    private double accountCredits;

    public Account(String accountName, AccountType accountType, double accountCredits) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountCredits = accountCredits;
    }

    public String getAccountName() {
        return accountName;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public double getAccountCredits() {
        return accountCredits;
    }

    public void setAccountCredits(double accountCredits) {
        this.accountCredits = accountCredits;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", accountCredits=" + accountCredits +
                '}';
    }

    /**
     * This function returns the Account String formated for Accounts file.
     * */
    public String formatedString(){
        StringJustifies sj = new StringJustifies();
        return sj.usernameFormated(accountName) + " " +
                accountType.accountTypeCode + " " + sj.availableCreditFormated(accountCredits);
    }
}
