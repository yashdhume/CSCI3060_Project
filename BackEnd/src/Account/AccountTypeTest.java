package Account;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTypeTest {

    @Test
    public void getType() throws Exception {
        //
        String fullStandard = "FS";
        String buyStandard = "BS";
        String sellStandard = "SS";
        String adminAccount = "AA";
        assertEquals(AccountType.getType(fullStandard), AccountType.FULL);
        assertEquals(AccountType.getType(buyStandard), AccountType.BUY);
        assertEquals(AccountType.getType(sellStandard), AccountType.SELL);
        assertEquals(AccountType.getType(adminAccount), AccountType.ADMIN);
    }
}