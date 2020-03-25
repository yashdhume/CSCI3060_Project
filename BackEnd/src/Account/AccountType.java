package Account;

public enum AccountType {
    FULL("FS"),
    BUY("BS"),
    SELL("SS"),
    ADMIN("AA");

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    String accountTypeCode;
    AccountType(String accountTypeCode){
        this.accountTypeCode = accountTypeCode;
    }
}
