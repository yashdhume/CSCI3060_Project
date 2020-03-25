package IO;

import Account.Account;

import java.io.IOException;
import java.util.ArrayList;

class AccountFileIO extends FileIO {
    private ArrayList<Account> accounts;

    public AccountFileIO(String fileName) {
        super(fileName);
        accounts = new ArrayList<>();
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void addAccounts(Account account){
        accounts.add(account);
    }
    public void removeAccount(Account account){
        accounts.remove(account);
    }
    public void openFile() throws IOException {
//        openInputStream();
//        /*
//
//
//         */
//        closeInputStream();
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
