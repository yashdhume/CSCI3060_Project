package IO;

import Account.*;

import java.util.ArrayList;

public class AccountFileIO extends FileIO {
    private ArrayList<Account> accounts;

    public AccountFileIO(String fileName) {
        super(fileName);
        accounts = new ArrayList<>();
    }

    /**
     * Returns all accounts from file
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    /**
     * Populates all accounts array from file
     */
    public void fetchAccountsFromFile() {
        ArrayList<String> lines = this.readLines();
        //For each line add account
        //UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        for (String line : lines) {
            AccountFileParser accountFileParser= new AccountFileParser(line);
            addAccount(new Account(accountFileParser.getAccountName(), accountFileParser.getAccountType(), accountFileParser.getAccountCredits()));
        }
    }

    public Account getAccountByName(String name) {
        for (Account account : accounts) {
            if (account.getAccountName().trim().equals(name.trim())) {
                return account;
            }
        }
        return null;
    }

    //Writes to file in an Account file
    public void writeToFile(){
        ArrayList<String> lines = new ArrayList<>();
        for(Account acc: accounts){
            lines.add(acc.formatedString());
        }
        this.writeLines(lines);
    }

//    public void closeFile() throws IOException{
//        openOutputStream();
//        /*
//
//
//         */
//        closeOutputStream();
//    }
}
