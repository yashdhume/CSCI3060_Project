package Transaction;

import Account.AccountType;
import Utilities.StringManipulation;

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
        //XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        StringManipulation sm = new StringManipulation();
        return TransactionType.SESSION_END.getAccountTypeCode() +
                " " + username+
                " " + accountType +
                " " + sm.availableCreditFormatted(availableCredit);
    }
}
