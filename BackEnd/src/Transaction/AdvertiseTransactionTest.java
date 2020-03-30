package Transaction;

import org.junit.Test;

import javax.management.BadAttributeValueExpException;

import static org.junit.Assert.*;

public class AdvertiseTransactionTest {

    @Test
    public void testToString() throws Exception {
        AdvertiseTransaction t = new AdvertiseTransaction("iname", "sName", "bName"
        , 10, 100.00);
        assertEquals("03 iname sName 010 100.00", t.toString());
    }
}