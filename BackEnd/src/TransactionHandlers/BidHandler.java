package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import IO.ItemFileIO;
import Item.Item;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.BidTransaction;

public class BidHandler extends BasicHandler {
    private AccountFileIO accountFileIO;
    private ItemFileIO itemFileIO;

    public BidHandler(AccountFileIO accountFileIO, ItemFileIO itemFileIO) {
        this.accountFileIO = accountFileIO;
        this.itemFileIO = itemFileIO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.BID;
    }

    @Override
    public String getName() {
        return "Bid";
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if(!checkType(transaction)){ return false; }
        BidTransaction bidTransaction = (BidTransaction)transaction;
        Account buyerAccount = accountFileIO.getAccountByName(bidTransaction.getBuyerUserName());
        Item item = itemFileIO.getItemByUserAndItemName(bidTransaction.getSellerUserName(), bidTransaction.getItemName());
        item.setHighestBidderUserName(buyerAccount.getAccountName());
        item.setMinimumBid(bidTransaction.getNewBid());
        buyerAccount.setAccountCredits(buyerAccount.getAccountCredits()-bidTransaction.getNewBid());
        return true;
    }
}
