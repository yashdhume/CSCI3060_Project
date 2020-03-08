package Accounts;

public enum AccountType {
    FULL("FS"),
    BUY("BS"),
    SELL("SS"),
    ADMIN("AA");
    String accountTypeCode;
    AccountType(String accountTypeCode){
        this.accountTypeCode = accountTypeCode;
    }
}
