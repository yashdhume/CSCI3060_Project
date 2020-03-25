import IO.AccountFileIO;
import IO.FileIO;
import Account.*;
import IO.TransactionFileIO;
import Item.*;
import IO.ItemFileIO;
import StringManipulation.StringJustifies;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

        TransactionFileIO tfio = new TransactionFileIO("Test_transactions.txt");
        tfio.fetchTransactionsFromFile();
    }
}
