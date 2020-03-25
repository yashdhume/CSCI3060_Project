package IO;

import Account.Account;
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

    public Item getItemByUserAndItemName(String sellerName, String itemName){
        for (Item item : items){
            if(item.getSellerUserName().equals(sellerName)&& item.getItemName().equals(itemName)) {
                return item;
            }
        }return null;
    }

    //Writes to file in an Item file
    public void writeToFile(){
        ArrayList<String> lines = new ArrayList<>();
        for(Item item: items){
            lines.add(item.formatedString());
        }
        this.writeLines(lines);
    }

}
