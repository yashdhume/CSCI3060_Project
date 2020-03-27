package IO;

import Account.AccountType;
import Item.Item;
import Transaction.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionFileIO extends FileIO {
    private ArrayList<Transaction> transactions;

    public TransactionFileIO(String fileName) {
        super(fileName);
        transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public void fetchTransactionsFromFile(){
        ArrayList<String> lines = this.readLines();

        //XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        TransactionType transactionCode;
        String username;
        AccountType atype;
        double availableCredit;
        for(String line: lines){
            username = line.substring(3,18);//Get Username
            atype = AccountType.getType(line.substring(19, 21));//Get Account type
            availableCredit = Double.parseDouble(line.substring(22));//Get Available Credit
            transactionCode = TransactionType.getTransactionEnum(line.substring(0,2));//Get transaction type

            //Add Transaction to Transactions ArrayList
            if (transactionCode == TransactionType.ADVERTISE) {
                transactionCode = TransactionType.ADVERTISE;
                //TODO Create a Advertise transaction object and add to ArrayList
                //AdvertiseTransaction(String itemName, String sellerUsername, String highestBidderUsername, int daysLeft, int minimumBid)
            } else if (transactionCode == TransactionType.BID) {
                transactionCode = TransactionType.BID;
                //TODO Create a BID transaction object and add to ArrayList
                //BidTransaction(String itemName, String sellerUserName, String highestBidderUserName, String buyerUserName,  double newBid)
            } else if (transactionCode == TransactionType.REFUND) {
                transactionCode = TransactionType.REFUND;
                //TODO Create a Refund transaction object and add to ArrayList
                //RefundTransaction(String sellerUserName, String highestBidderUserName, double itemCredits)
            }else{
                transactions.add(new Transaction(transactionCode, username, atype, availableCredit));
            }

            //Debug print
            System.out.println(line.substring(0,2) + " " + line.substring(3,18)
                + " " + line.substring(19, 21) + " " + line.substring(22));

        }
    }
}
