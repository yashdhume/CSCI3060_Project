package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.CreateTransaction;

public class CreateHandler extends BasicHandler{
    private AccountFileIO accountFileIO;

    public CreateHandler(AccountFileIO accountFileIO) {
        this.accountFileIO = accountFileIO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.CREATE;
    }

    @Override
    public String getName() {
        return "Create";
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if (!checkType(transaction)) return false;
        CreateTransaction createTransaction = (CreateTransaction)transaction;
        Account account = accountFileIO.getAccountByName((createTransaction.getAccountName()));
        if(account!=null) {
            System.out.println("Account Already Exist");
            return false;//already exist
        }
        account = new Account(createTransaction.getAccountName(), createTransaction.getAccountType(), createTransaction.getAccountCredits());
        accountFileIO.addAccount(account);
        return true;
    }
}
