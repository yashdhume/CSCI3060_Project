package IO;

import Account.*;

import java.io.IOException;
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
        fetchAccountsFromFile();
        return accounts;
    }

    public void addAccounts(Account account) {
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
        String username;
        AccountType atype;
        double credit;
        //For each line add account
        //UUUUUUUUUUUUUUU_TT_CCCCCCCCC
        for (String line : lines) {
            username = line.substring(0, 15);
            atype = AccountType.BUY;
            if (line.substring(16, 18).equals(AccountType.FULL.getAccountTypeCode())) {
                atype = AccountType.FULL;
            } else if (line.substring(16, 18).equals(AccountType.SELL.getAccountTypeCode())) {
                atype = AccountType.SELL;
            } else if (line.substring(16, 18).equals(AccountType.ADMIN.getAccountTypeCode())) {
                atype = AccountType.ADMIN;
            }
            credit = Double.parseDouble(line.substring(19));
            addAccounts(new Account(username, atype, credit));
        }
    }

    public Account getAccountByName(String name) {
        for (Account account : accounts) {
            if (account.getAccountName().equals(name)) {
                return account;
            }
        }
        return null;
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
