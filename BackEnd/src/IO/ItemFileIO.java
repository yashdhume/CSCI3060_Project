package IO;

import Item.Item;

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
        for(String line: lines){
            ItemFileParser itemFileParser = new ItemFileParser(line);
            addItems(new Item(itemFileParser.getItemName(), itemFileParser.getSellerUserName(), itemFileParser.getHighestBidderUserName(), itemFileParser.getNumberOfDays(), itemFileParser.getCurrentHighestBid()));
        }

    }

    public Item getItemByUserAndItemName(String sellerName, String itemName){
        for (Item item : items){
            if(item.getSellerUserName().trim().equals(sellerName.trim())&& item.getItemName().trim().equals(itemName.trim())) {
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
