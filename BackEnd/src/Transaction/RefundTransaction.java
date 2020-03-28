package Transaction;

public class RefundTransaction extends Transaction{
    private String sellerUserName;
    private String highestBidderUserName;
    private double itemCredits;

    public RefundTransaction(String sellerUserName, String highestBidderUserName, double itemCredits) {
        super(TransactionType.REFUND);
        this.sellerUserName = sellerUserName;
        this.highestBidderUserName = highestBidderUserName;
        this.itemCredits = itemCredits;
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

    public double getItemCredits() {
        return itemCredits;
    }

    public void setItemCredits(double itemCredits) {
        this.itemCredits = itemCredits;
    }

    @Override
    public String toString() {
        return "RefundTransaction{" +
                "sellerUserName='" + sellerUserName + '\'' +
                ", highestBidderUserName='" + highestBidderUserName + '\'' +
                ", itemCredits=" + itemCredits +
                '}';
    }
}
