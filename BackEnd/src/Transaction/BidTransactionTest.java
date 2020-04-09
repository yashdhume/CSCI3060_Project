package Transaction;

import org.junit.Test;

import static org.junit.Assert.*;

public class BidTransactionTest {

    @Test
    public void testToString() throws Exception{
        BidTransaction t = new BidTransaction("iname", "sname", "bname", "buyname",
                100.0);
        assertEquals("04 iname sname buyname 100.00", t.toString());

    }
}