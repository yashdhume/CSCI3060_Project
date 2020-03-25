import IO.AccountFileIO;
import IO.FileIO;
import Account.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

        AccountFileIO afio = new AccountFileIO("Test_accounts.txt");
        for(Account acc: afio.getAccounts()){
            System.out.println(acc);
        }



    }
}
