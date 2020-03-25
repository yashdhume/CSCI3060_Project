import IO.FileIO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

        FileIO fio = new FileIO("Test_accounts.txt");

        ArrayList<String> lines = fio.readLines();

        for(String line: lines){
            System.out.println(line);
        }

    }
}
