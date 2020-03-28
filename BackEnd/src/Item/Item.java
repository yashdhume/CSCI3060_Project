package Item;

import Utilities.StringManipulation;

public class Item {
    private String itemName;
    private String sellerUserName;
    private String highestBidderUserName;
    private int daysLeft;
    private double currentHighestBid;
    private double minimumBid;
    private boolean newItemName;

    public Item(String itemName, String sellerUserName, String highestBidderUserName, int daysLeft, double minimumBid) {
        this.itemName = itemName;
        this.sellerUserName = sellerUserName;
        this.highestBidderUserName = highestBidderUserName;
        this.daysLeft = daysLeft;
        this.minimumBid = minimumBid;
    }



    public double getCurrentHighestBid() {
        return currentHighestBid;
    }

    public void setCurrentHighestBid(double currentHighestBid) {
        this.currentHighestBid = currentHighestBid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public void setSellerUserName(String sellerUserName) {
        this.sellerUserName = sellerUserName;
    }

    public String getHighestBidderUserName() {
        return highestBidderUserName;
    }

    public void setHighestBidderUserName(String highestBidderUserName) {
        this.highestBidderUserName = highestBidderUserName;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public double getMinimumBid() {
        return minimumBid;
    }

    public void setMinimumBid(double minimumBid) {
        this.minimumBid = minimumBid;
    }

    public void setNewItemName(boolean newItemName) {
        this.newItemName = newItemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", sellerUserName='" + sellerUserName + '\'' +
                ", highestBidderUserName='" + highestBidderUserName + '\'' +
                ", daysLeft=" + daysLeft +
                ", currentHighestBid=" + currentHighestBid +
                '}';
    }

    public String formatedString(){
        StringManipulation sj = new StringManipulation();
        return sj.itemNameFormatted(itemName) + " " +
                sj.usernameFormatted(sellerUserName) + " " +
                sj.usernameFormatted(highestBidderUserName) + " " +
                sj.numOfDaysFormatted(daysLeft) + " " +
                sj.newBidFormatted(currentHighestBid);
    }
}
