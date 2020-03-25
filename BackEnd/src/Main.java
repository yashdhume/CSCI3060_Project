import IO.AccountFileIO;
import IO.FileIO;
import Account.*;
import Item.*;
import IO.ItemFileIO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

//        //Get Accounts from File example
//        AccountFileIO afio = new AccountFileIO("Test_accounts.txt");
//        for(Account acc: afio.getAccounts()){
//            System.out.println(acc);
//        }

        //Get Items from file example
        ItemFileIO ifio = new ItemFileIO("Test_items.txt");
        for(Item item: ifio.getItems()){
            System.out.println(item);
        }



    }
}
