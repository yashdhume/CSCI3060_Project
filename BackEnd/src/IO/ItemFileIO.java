package IO;

import Item.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ItemFileIO extends FileIO {
    private ArrayList<Item> items;

    public ItemFileIO(String fileName) {
        super(fileName);
        items = new ArrayList<>();
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItems(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
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
