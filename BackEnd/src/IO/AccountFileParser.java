package IO;

import Account.AccountType;

public class AccountFileParser {
    private String line;
    public AccountFileParser(String line) {
        this.line = line;
    }
    public String getAccountName(){
        return line.substring(0,15);
    }
    public AccountType getAccountType(){
        AccountType accountType;
        String fromFile=line.substring(16,18);
        accountType = AccountType.BUY;
        if (fromFile.equals(AccountType.FULL.getAccountTypeCode())) {
            accountType = AccountType.FULL;
        } else if (fromFile.equals(AccountType.SELL.getAccountTypeCode())) {
            accountType = AccountType.SELL;
        } else if (fromFile.equals(AccountType.ADMIN.getAccountTypeCode())) {
            accountType = AccountType.ADMIN;
        }
        return accountType;
    }
    public Double getAccountCredits(){
        return Double.parseDouble(line.substring(19));
    }
}
