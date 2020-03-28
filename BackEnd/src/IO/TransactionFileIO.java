package IO;

import Account.Account;
import Account.AccountType;
import Transaction.*;

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

    /**
     * Populates all transactions array from file
     */
    public void fetchTransactionsFromFile(){
        ArrayList<String> lines = this.readLines();

        //XX_UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        TransactionType transactionCode;
        String username;
        AccountType atype;
        double availableCredit;

        for(String line: lines){

            transactionCode = TransactionType.getTransactionEnum(line.substring(0,2));//Get transaction type

            //Add Transaction to Transactions ArrayList
            if (transactionCode == TransactionType.ADVERTISE) {
                transactionCode = TransactionType.ADVERTISE;

                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_DDD_PPPPPP
                String itemName = line.substring(3, 22);
                String sellerUsername = line.substring(23, 38);
                int numOfAucDays = Integer.parseInt(line.substring(39, 42));
                double minBid = Double.parseDouble(line.substring(43));

                System.out.println(itemName.length());
                System.out.println(sellerUsername.length());

                transactions.add(new AdvertiseTransaction(itemName, sellerUsername, "", numOfAucDays, minBid));

            } else if (transactionCode == TransactionType.BID) {
                transactionCode = TransactionType.BID;
                //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUUU_PPPPPP

                String itemName = line.substring(3, 22);
                String sellerUserName = line.substring(23, 38);
                String buyerUserName = line.substring(39, 54);
                double newBid = Double.parseDouble(line.substring(55));

                transactions.add(new BidTransaction(itemName, sellerUserName, "", buyerUserName, newBid));

            } else if (transactionCode == TransactionType.REFUND) {
                transactionCode = TransactionType.REFUND;

                //XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
                String buyerUserName = line.substring(3, 18);
                String sellerUserName = line.substring(19, 34);
                double refundCredit = Double.parseDouble(line.substring(35));

                transactions.add(new RefundTransaction(sellerUserName, buyerUserName, refundCredit));


            } else if (transactionCode == TransactionType.CREATE) {
                transactionCode = TransactionType.CREATE;

                username = line.substring(3,18);//Get Username
                atype = AccountType.getType(line.substring(19, 21));//Get Account type
                availableCredit = Double.parseDouble(line.substring(22));//Get Available Credit

                transactions.add(new CreateTransaction(username, atype, availableCredit));
            } else if (transactionCode == TransactionType.DELETE) {
                transactionCode = TransactionType.DELETE;

                username = line.substring(3,18);//Get Username
                atype = AccountType.getType(line.substring(19, 21));//Get Account type
                availableCredit = Double.parseDouble(line.substring(22));//Get Available Credit

                transactions.add(new DeleteTransaction(username, atype, availableCredit));
            } else if (transactionCode == TransactionType.ADD_CREDIT) {
                transactionCode = TransactionType.ADD_CREDIT;

                username = line.substring(3,18);//Get Username
                atype = AccountType.getType(line.substring(19, 21));//Get Account type
                availableCredit = Double.parseDouble(line.substring(22));//Get Available Credit

                transactions.add(new AddCreditTransaction(username, atype, availableCredit));
            } else{
                username = line.substring(3,18);//Get Username
                atype = AccountType.getType(line.substring(19, 21));//Get Account type
                availableCredit = Double.parseDouble(line.substring(22));//Get Available Credit

                //SESSION_END
                transactions.add(new SessionEndTransaction(username, atype, availableCredit));
            }

        }
    }

    //Writes to file in an Account file
    public void writeToFile(){
        ArrayList<String> lines = new ArrayList<>();
        for(Transaction transaction: transactions){
            lines.add(transaction.toString());
        }
        this.writeLines(lines);
    }
}
