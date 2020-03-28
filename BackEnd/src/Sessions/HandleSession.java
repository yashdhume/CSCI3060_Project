package Sessions;

import IO.AccountFileIO;
import IO.ItemFileIO;
import IO.TransactionFileIO;
import Transaction.Transaction;
import TransactionHandlers.*;

public class HandleSession {
    private String accountFilePath;
    private String itemFilePath;
    private String transactionFilePath;

    public HandleSession(String accountFilePath, String itemFilePath, String transactionFilePath) {
        this.accountFilePath = accountFilePath;
        this.itemFilePath = itemFilePath;
        this.transactionFilePath = transactionFilePath;
    }

    public void run(){
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
                if(transactionComplete)System.out.println(transaction.getTransactionType()+ " " +"Completed");
            }
        }

        accountFileIO.writeToFile();
        itemFileIO.writeToFile();

    }
}
