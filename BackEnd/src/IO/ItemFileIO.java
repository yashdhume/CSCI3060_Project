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
        fetchAccountsFromFile();
        return items;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void fetchAccountsFromFile(){
        ArrayList<String> lines = this.readLines();

        //IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_UUUUUUUUUUUUUUU_111_111111
        //                    SSSSSSSSSSSSSSS_UUUUUUUUUUUUUUU
        String itemName;
        String sellerUsername;
        String winBidUsername;
        int numOfDays;
        double currHighestBid;
        for(String line: lines){
            itemName = line.substring(0,19);
            sellerUsername = line.substring(20,35);
            winBidUsername = line.substring(36,51);
            numOfDays = Integer.parseInt(line.substring(52,55));
            currHighestBid = Double.parseDouble(line.substring(56));
            addItems(new Item(itemName, sellerUsername, winBidUsername, numOfDays, currHighestBid));
        }

    }
//    public void closeFile() throws IOException{
//        openOutputStream();
//        /*
//
//
//         */
//        closeOutputStream();
//    }
}
