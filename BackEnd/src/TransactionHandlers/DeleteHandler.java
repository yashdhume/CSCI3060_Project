package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.DeleteTransaction;

public class DeleteHandler extends BasicHandler {
    AccountFileIO accountFileIO;

    public DeleteHandler(AccountFileIO accountFileIO) {
        this.accountFileIO = accountFileIO;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.DELETE;
    }

    @Override
    public String getName() {
        return "Delete";
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if (!checkType(transaction)) return false;
        DeleteTransaction deleteTransaction = (DeleteTransaction)transaction;
        Account account = accountFileIO.getAccountByName((deleteTransaction.getAccountName()));
        if(account==null) return false;
        accountFileIO.removeAccount(account);
        return true;
    }
}
