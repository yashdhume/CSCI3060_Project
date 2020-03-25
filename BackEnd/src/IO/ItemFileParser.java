package IO;

public class ItemFileParser {
    private String line;

    public ItemFileParser(String line) {
        this.line = line;
    }
    public String getItemName(){
        return line.substring(0,19);
    }
    public String getSellerUserName(){
        return line.substring(20,35);
    }
    public String getHighestBidderUserName(){
        return line.substring(36,51);
    }
    public int getNumberOfDays(){
        return Integer.parseInt(line.substring(52,55));
    }
    public Double getCurrentHighestBid(){
        return Double.parseDouble(line.substring(56));
    }
}
