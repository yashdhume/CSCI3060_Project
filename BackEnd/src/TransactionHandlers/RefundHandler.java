package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.RefundTransaction;

public class RefundHandler extends BasicHandler {
    private AccountFileIO accountFileIO;

    public RefundHandler(AccountFileIO accountFileIO) {
        this.accountFileIO = accountFileIO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.REFUND;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if(!checkType(transaction)) return false;
        RefundTransaction refundTransaction = (RefundTransaction) transaction;
        Account sellerAccount = accountFileIO.getAccountByName(refundTransaction.getSellerUserName());
        if(sellerAccount==null){
            System.out.println("Seller Account does not exist");
            return false;
        }
        Account buyerAccount = accountFileIO.getAccountByName(refundTransaction.getHighestBidderUserName());
        if (buyerAccount==null){
            System.out.println("Buyer Account does not exist");
            return false;
        }
        sellerAccount.setAccountCredits(sellerAccount.getAccountCredits()-refundTransaction.getItemCredits());
        buyerAccount.setAccountCredits(buyerAccount.getAccountCredits()+refundTransaction.getItemCredits());
        return true;
    }
}
