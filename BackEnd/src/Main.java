import IO.TransactionFileIO;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

        TransactionFileIO tfio = new TransactionFileIO("Test_transactions.txt");
        tfio.fetchTransactionsFromFile();
    }
}
