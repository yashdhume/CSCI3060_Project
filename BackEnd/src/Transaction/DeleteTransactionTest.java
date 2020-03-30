package Transaction;

import Account.AccountType;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteTransactionTest {

    @Test
    public void testToString() {
        DeleteTransaction t = new DeleteTransaction("name", AccountType.BUY, 100.00);
        assertEquals("02 name BUY 000100.00", t.toString());
    }
}