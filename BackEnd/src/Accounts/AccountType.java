package Accounts;

public class AccountType {
    public static final int NONE = -1;
    public static final int BUY = 0;
    public static final int SELL = 1;
    public static final int FULL = 2;
    public static final int ADMIN = 3;
    public static int getAccountTypeFromString(String type){
        if (type.equals("BS")){
            return BUY;
        }
        else if(type.equals("SS")){
            return SELL;
        }
        else if(type.equals("FS")){
            return FULL;
        }
        else if (type.equals("AA")){
            return ADMIN;
        }
        else {
            return NONE;
        }
    }
}
