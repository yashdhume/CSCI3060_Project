package Account;

public enum AccountType {
    FULL("FS"),
    BUY("BS"),
    SELL("SS"),
    ADMIN("AA");

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public static AccountType getType(String accType){
        if (accType.equals(AccountType.FULL.getAccountTypeCode())) {
            return AccountType.FULL;
        } else if (accType.equals(AccountType.SELL.getAccountTypeCode())) {
            return AccountType.SELL;
        } else if (accType.equals(AccountType.ADMIN.getAccountTypeCode())) {
            return AccountType.ADMIN;
        }else{
            return AccountType.BUY;
        }
    }


    String accountTypeCode;
    AccountType(String accountTypeCode){
        this.accountTypeCode = accountTypeCode;
    }
}
