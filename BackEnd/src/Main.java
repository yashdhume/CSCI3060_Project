import Sessions.DayEndSession;
import Sessions.HandleSession;

public class Main {
    public static void main(String[] args) {
        DayEndSession dayEndSession = new DayEndSession("Test_accounts.txt", "Test_items.txt", "Test_transactions.txt");
        dayEndSession.run();
        HandleSession handleSession = new HandleSession("Test_accounts.txt", "Test_items.txt", "Test_transactions.txt");
        handleSession.run();
    }
}
