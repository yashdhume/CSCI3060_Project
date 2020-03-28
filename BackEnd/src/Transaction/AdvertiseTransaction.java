package Transaction;

import Utilities.StringManipulation;

public class AdvertiseTransaction extends Transaction {
    private String itemName;
    private String sellerUsername;
    private String highestBidderUsername;
    private int daysLeft;
    private double minimumBid;

    public AdvertiseTransaction(String itemName, String sellerUsername, String highestBidderUsername, int daysLeft, double minimumBid) {
        super(TransactionType.ADVERTISE);
        this.itemName = itemName;
        this.sellerUsername = sellerUsername;
        this.highestBidderUsername = highestBidderUsername;
        this.daysLeft = daysLeft;
        this.minimumBid = minimumBid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getHighestBidderUsername() {
        return highestBidderUsername;
    }

    public void setHighestBidderUsername(String highestBidderUsername) {
        this.highestBidderUsername = highestBidderUsername;
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

    @Override
    public String toString() {
        //XX_IIIIIIIIIIIIIIIIIII_SSSSSSSSSSSSSSS_DDD_PPPPPP
        StringManipulation sm = new StringManipulation();
        return TransactionType.ADVERTISE +
                " " + itemName +
                " " + sellerUsername +
                " " + sm.numOfDaysFormatted(daysLeft) +
                " " + sm.newBidFormatted(minimumBid);
    }
}

