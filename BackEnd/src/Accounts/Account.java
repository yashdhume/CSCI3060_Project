package Accounts;

public class Account {
    private String accountName;
    private String accountType;
    private double accountCredits;

    public Account(String accountName, String accountType, double accountCredits) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountCredits = accountCredits;
    }

    public String getAccountName() {
        return accountName;
    }


    public String getAccountType() {
        return accountType;
    }

    public double getAccountCredits() {
        return accountCredits;
    }

    public void setAccountCredits(double accountCredits) {
        this.accountCredits = accountCredits;
    }
}
