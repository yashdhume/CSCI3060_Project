package Transaction;

public class BidTransaction extends Transaction{
    private String itemName;
    private String sellerUserName;
    private String highestBidderUserName;
    private double newBid;

    public BidTransaction(String itemName, String sellerUserName, String highestBidderUserName, double newBid) {
        super(TransactionType.BID);
        this.itemName = itemName;
        this.sellerUserName = sellerUserName;
        this.highestBidderUserName = highestBidderUserName;
        this.newBid = newBid;
    }
}
