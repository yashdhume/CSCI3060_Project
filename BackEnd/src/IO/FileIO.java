package IO;

import java.io.*;
import java.util.ArrayList;

class FileIO {
    private String fileName;
    private InputStream inputStream;
    private OutputStream outputStream;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<String> readLine(){
        return null;
    }
    public void writeLine(){

    }
    public void openInputStream() throws FileNotFoundException {
        inputStream= new FileInputStream(fileName);
    }
    public void openOutputStream() throws FileNotFoundException{
        File file;
        outputStream = new FileOutputStream(fileName);
    }
    public void closeInputStream() throws IOException {
        inputStream.close();
    }
    public void closeOutputStream() throws IOException {
        outputStream.close();
    }

}
