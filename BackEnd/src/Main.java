import IO.AccountFileIO;
import IO.ItemFileIO;
import IO.TransactionFileIO;
import Transaction.Transaction;
import TransactionHandlers.*;

public class Main {
    public static void main(String[] args) {
        AccountFileIO accountFileIO = new AccountFileIO("Test_accounts.txt");
        accountFileIO.fetchAccountsFromFile();
        ItemFileIO itemFileIO = new ItemFileIO("Test_items.txt");
        itemFileIO.fetchAccountsFromFile();
        TransactionFileIO transactionFileIO = new TransactionFileIO("Test_transactions.txt");
        transactionFileIO.fetchTransactionsFromFile();
        TransactionHandler[] transactionHandlers = new TransactionHandler[]{
                new AddCreditHandler(accountFileIO),
                new AdvertiseHandler(accountFileIO, itemFileIO),
                new BidHandler(accountFileIO, itemFileIO),
                new CreateHandler(accountFileIO),
                new DeleteHandler(accountFileIO),
                new RefundHandler(accountFileIO)
        };
        for(Transaction transaction : transactionFileIO.getTransactions()){
            for(TransactionHandler handler: transactionHandlers){
                boolean transactionComplete = handler.handleTransaction(transaction);
            }
        }


    }
}
