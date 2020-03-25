package Utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringManipulation {
    //adds spaces to the left of a string to make it a certain length
    String leftJustify(String str, char filler, int length){
      return"";
    }

    //adds spaces to the right of a string to make it a certain length
    String rightJustify(String str, char filler, int length){
        return "";
    }

    //Returns a character with 15 characters for username format
    public String usernameFormatted(String username){
        return formatString(username, 15);
    }

    public String formatString(String string, int stringLength){
        if(string.length() == stringLength){
            return string;
        }else if(string.length() < stringLength){
            return String.format("%-"+ stringLength + "s", string);
        }else{
            return string.substring(0,stringLength);
        }
    }

    //Returns a character with 19 characters for username format
    public String itemNameFormatted(String itemName){
        return formatString(itemName, 19);
    }

    //Formats available credit to 9 digits
    public String availableCreditFormatted(double money){
        NumberFormat formatter = new DecimalFormat("#000000.00");
        return formatter.format(money);
    }

    //Formats newbid to 6 digits
    public String newBidFormatted(double money){
        NumberFormat formatter = new DecimalFormat("#000.00");
        return formatter.format(money);
    }

    public String numOfDaysFormatted(int days){
        NumberFormat formatter = new DecimalFormat("#000");
        return formatter.format(days);
    }

}
