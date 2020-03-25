package Transaction;

public class BidTransaction extends Transaction{
    private String itemName;
    private String sellerUserName;
    private String buyerUserName;
    private String highestBidderUserName;
    private double newBid;

    public BidTransaction(String itemName, String sellerUserName, String highestBidderUserName, String buyerUserName,  double newBid) {
        super(TransactionType.BID);
        this.itemName = itemName;
        this.sellerUserName = sellerUserName;
        this.highestBidderUserName = highestBidderUserName;
        this.newBid = newBid;
        this.buyerUserName = buyerUserName;
    }

    public String getBuyerUserName() {
        return buyerUserName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public String getHighestBidderUserName() {
        return highestBidderUserName;
    }

    public double getNewBid() {
        return newBid;
    }
}
