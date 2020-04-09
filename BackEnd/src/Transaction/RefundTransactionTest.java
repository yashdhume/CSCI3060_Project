package Transaction;

import org.junit.Test;

import java.sql.Ref;

import static org.junit.Assert.*;

public class RefundTransactionTest {

    @Test
    public void testToString() {
        RefundTransaction T = new RefundTransaction("user", "buser", 100.00);
        //assertEquals("user buser");
    }
}