package Transaction;

import Account.AccountType;
import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.*;

public class AddCreditTransactionTest {

    @Test
    public void testToString() throws Exception{
        AddCreditTransaction t = new AddCreditTransaction("username", AccountType.BUY, 100);
        assertEquals(TransactionType.ADD_CREDIT.getAccountTypeCode()+
                " " + "username" +
                " " + AccountType.BUY +
                " " + "000100.00", t.toString());
    }
}