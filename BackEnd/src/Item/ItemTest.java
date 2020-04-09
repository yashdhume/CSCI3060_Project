package Item;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testToString() throws Exception {
        Item item = new Item("name", "sUsername", "bUsername", 10, 100.0);
        assertEquals("Item{" +
                "itemName='" + "name" + '\'' +
                ", sellerUserName='" + "sUsername" + '\'' +
                ", highestBidderUserName='" + "bUsername" + '\'' +
                ", daysLeft=" + "10" +
                ", currentHighestBid=" + "0.0" +
                '}', item.toString());
    }

    @Test
    public void formatedString() throws Exception {
        Item item = new Item("name", "sUsername", "bUsername", 10, 100.0);
        String name = "name                ";
        String sUser = "sUsername       ";
        String bUser = "bUsername       ";
        String days = "010";
        String highestbid = "000.00";
        assertEquals(name + sUser + bUser + days + " " + highestbid,item.formatedString());

    }
}