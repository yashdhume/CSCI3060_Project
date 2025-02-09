package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import IO.ItemFileIO;
import Item.Item;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.AdvertiseTransaction;

public class AdvertiseHandler extends BasicHandler {
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
        return "Advertise";
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if (!checkType(transaction)) return false;

        AdvertiseTransaction advertiseTransaction = (AdvertiseTransaction) transaction;

        Account account = accountFileIO.getAccountByName(advertiseTransaction.getSellerUsername());
        if (account == null){
            System.out.println("Account Does Not Exist");
            return false;
        }
        Item item = itemFileIO.getItemByUserAndItemName(advertiseTransaction.getSellerUsername(), advertiseTransaction.getItemName());
        if (item != null) {
            System.out.println("Item Already Exist");
            return false;
        }
        item = new Item(advertiseTransaction.getItemName(), advertiseTransaction.getSellerUsername(), "", advertiseTransaction.getDaysLeft(), advertiseTransaction.getMinimumBid());
        item.setCurrentHighestBid(advertiseTransaction.getMinimumBid());
        itemFileIO.addItems(item);

        return true;
    }
}
