package StringManipulation;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringJustifies {
    //adds spaces to the left of a string to make it a certain length
    String leftJustify(String str, char filler, int length){
      return"";
    }

    //adds spaces to the right of a string to make it a certain length
    String rightJustify(String str, char filler, int length){
        return "";
    }

    //Returns a character with 15 characters for username format
    public String usernameFormated(String username){
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
    public String itemNameFormated(String itemName){
        return formatString(itemName, 19);
    }

    //Formats available credit to 9 digits
    public String availableCreditFormated(double money){
        NumberFormat formatter = new DecimalFormat("#000000.00");
        return formatter.format(money).toString();
    }

    //Formats newbid to 6 digits
    public String newBidFormated(double money){
        NumberFormat formatter = new DecimalFormat("#000.00");
        return formatter.format(money).toString();
    }

    public String numOfDaysFormated(int days){
        NumberFormat formatter = new DecimalFormat("#000");
        return formatter.format(days).toString();
    }

}
