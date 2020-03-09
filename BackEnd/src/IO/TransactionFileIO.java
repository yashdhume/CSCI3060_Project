package IO;

import Transaction.Transaction;

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
    public void addTransactions(Transaction transaction){
        transactions.add(transaction);
    }
    public void removeTransaction(Transaction transaction){
        transactions.remove(transaction);
    }
    public void openFile() throws IOException {
        openInputStream();
        /*


         */
        closeInputStream();
    }
    public void closeFile() throws IOException{
        openOutputStream();
        /*


         */
        closeOutputStream();
    }
}
