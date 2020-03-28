package Sessions;

import Account.Account;
import IO.AccountFileIO;
import IO.ItemFileIO;
import IO.TransactionFileIO;
import Item.Item;

import java.util.Iterator;

public class DayEndSession {
    private String accountFilePath;
    private String itemFilePath;
    private String transactionFilePath;

    public DayEndSession(String accountFilePath, String itemFilePath, String transactionFilePath) {
        this.accountFilePath = accountFilePath;
        this.itemFilePath = itemFilePath;
        this.transactionFilePath = transactionFilePath;
    }

    public void run(){
        AccountFileIO accountFileIO = new AccountFileIO(accountFilePath);
        accountFileIO.fetchAccountsFromFile();
        ItemFileIO itemFileIO = new ItemFileIO(itemFilePath);
        itemFileIO.fetchAccountsFromFile();
        TransactionFileIO transactionFileIO = new TransactionFileIO(transactionFilePath);
        transactionFileIO.fetchTransactionsFromFile();
        for (Iterator<Item> iterator = itemFileIO.getItems().iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            if (item.getDaysLeft() == 0) {
                Account sellerAccount = accountFileIO.getAccountByName(item.getSellerUserName());
                sellerAccount.setAccountCredits(sellerAccount.getAccountCredits() + item.getMinimumBid());
                iterator.remove();
                continue;
            }
            item.setDaysLeft(item.getDaysLeft() - 1);
        }
        System.out.println("Day end processed");
        accountFileIO.writeToFile();
        itemFileIO.writeToFile();
        accountFileIO.closeOutputStream();
        accountFileIO.closeInputStream();
        itemFileIO.closeOutputStream();
        itemFileIO.closeInputStream();
    }
}
