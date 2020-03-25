package IO;

import java.io.*;
import java.util.ArrayList;

public class FileIO {
    private String fileName;
    private InputStream inputStream;
    private OutputStream outputStream;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This function returns lines from file
     */
    public ArrayList<String> readLines() {
        ArrayList<String> allLines = new ArrayList<>();

        //Test_accounts.txt
        try {
            BufferedReader br = openInputStream();
            String line;
            while (!(line = br.readLine()).trim().equals("END")) {
                allLines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.toString());
        } catch (IOException e) {
            System.out.println("Read line error: " + e.toString());
        }
        this.closeInputStream();

        return allLines;
    }

    /**
     * This function writes a line
     */
    public void writeLine(String line) {
        try {
            this.openInputStream();
            outputStream.write(line.getBytes());
            this.closeOutputStream();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.toString());
        } catch (IOException e) {
            System.out.println("Writing Line error: " + e.toString());
        }
    }

    public void writeLines(ArrayList<String> lines) {
        for (String line : lines) {
            writeLine(line);
        }
        writeLine("END");
    }

    /**
     * Opens input stream and returns a buffered reader
     */
    public BufferedReader openInputStream() throws FileNotFoundException {
        inputStream = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(isr);
        return reader;
    }

    public void openOutputStream() throws FileNotFoundException {
        File file = new File(fileName);
        outputStream = new FileOutputStream(file);
    }

    public void closeInputStream(){
        try {
            inputStream.close();
        } catch (IOException e) {
            System.out.println("InputStream close error: " + e.toString());
        }
    }

    public void closeOutputStream() {
        try {
            outputStream.close();
        } catch (IOException e) {
            System.out.println("OutputStream close error: " + e.toString());
        }
    }

}
