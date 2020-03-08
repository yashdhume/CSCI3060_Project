package Transaction;

public class AdvertiseTransaction extends Transaction {
    private String itemName;
    private String sellerUsername;
    private String highestBidder;
    private int daysLeft;
    private int minimumBid;

    public AdvertiseTransaction(String itemName, String sellerUsername, String highestBidder, int daysLeft, int minimumBid) {
        super(TransactionType.ADVERTISE);
        this.itemName = itemName;
        this.sellerUsername = sellerUsername;
        this.highestBidder = highestBidder;
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

    public String getHighestBidder() {
        return highestBidder;
    }

    public void setHighestBidder(String highestBidder) {
        this.highestBidder = highestBidder;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getMinimumBid() {
        return minimumBid;
    }

    public void setMinimumBid(int minimumBid) {
        this.minimumBid = minimumBid;
    }
}

