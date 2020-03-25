package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import IO.ItemFileIO;
import Item.Item;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.AdvertiseTransaction;

public class AdvertiseHandler extends BasicHandler{
    private AccountFileIO accountFileIO;
    private ItemFileIO itemFileIO;

    public AdvertiseHandler(AccountFileIO accountFileIO, ItemFileIO itemFileIO) {
        this.accountFileIO = accountFileIO;
        this.itemFileIO = itemFileIO;
    }
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADVERTISE;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean addItemTransaction(Transaction transaction) {
        if(!checkType(transaction)){ return false; }
        AdvertiseTransaction advertiseTransaction = (AdvertiseTransaction)transaction;
        Account account =  accountFileIO.getAccountByName(advertiseTransaction.getSellerUsername());
        if (account==null) return false;
        Item item = itemFileIO.getItemByUserAndItemName(advertiseTransaction.getSellerUsername(), advertiseTransaction.getItemName());
        if(item==null) return false;
        item = new Item(advertiseTransaction.getItemName(), advertiseTransaction.getSellerUsername(), "", advertiseTransaction.getDaysLeft(), advertiseTransaction.getMinimumBid(), true);
        itemFileIO.addItems(item);
        return true;
    }
}
