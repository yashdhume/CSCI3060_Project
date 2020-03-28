package Transaction;

import Utilities.StringManipulation;

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
        //XX_UUUUUUUUUUUUUUU_SSSSSSSSSSSSSSS_CCCCCCCCC
        StringManipulation sm = new StringManipulation();
        return TransactionType.REFUND.getAccountTypeCode() +
                " " + highestBidderUserName +
                " " + sellerUserName +
                " " + sm.availableCreditFormatted(itemCredits);
    }
}
