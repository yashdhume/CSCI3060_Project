package Account;

import static org.junit.Assert.*;

public class AccountTest {

    @org.junit.Test
    public void testToString() throws Exception {
        Account acc = new Account("name", AccountType.BUY, 100.0);
        assertEquals("Account{" +
                "accountName='" + "name" + '\'' +
                ", accountType=" + AccountType.BUY +
                ", accountCredits=" + 100.0 +
                '}', acc.toString());


    }

    @org.junit.Test
    public void formatedString() throws Exception {
        Account acc = new Account("name", AccountType.BUY, 100.0);
        // Format: UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        String accN = "name           ";
        String accCredit = "000100.00";
        assertEquals(accN+" BS "+accCredit, acc.formatedString());
    }
}