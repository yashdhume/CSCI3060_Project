package Transaction;

import Account.AccountType;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateTransactionTest {

    @Test
    public void testToString() {
        CreateTransaction t = new CreateTransaction("user", AccountType.BUY, 100.00);
        assertEquals("01 user BUY 000100.00", t.toString());
    }
}