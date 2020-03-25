import IO.FileIO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello ");

        FileIO fio = new FileIO("Test_FileWriteTest.txt");

        ArrayList<String> lines = new ArrayList<>();
        lines.add("SDFsdf");
        lines.add("asdfsadf");
        lines.add("asdfasdf");

        fio.writeLines(lines);

//
//        for(String line: lines){
//            System.out.println(line);
//        }


    }
}
