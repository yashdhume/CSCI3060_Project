package TransactionHandlers;

import Account.Account;
import IO.AccountFileIO;
import Transaction.Transaction;
import Transaction.TransactionType;
import Transaction.AddCreditTransaction;

public class AddCreditHandler extends BasicHandler{
    private AccountFileIO accountFileIO;
    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADD_CREDIT;
    }

    @Override
    public String getName() {
        return "Add Credit";
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        if(!checkType(transaction)) return false;
        AddCreditTransaction addCreditTransaction = (AddCreditTransaction) transaction;
        Account account = accountFileIO.getAccountByName(addCreditTransaction.getAccountName());
        if (account == null) return false;
        account.setAccountCredits(addCreditTransaction.getAccountCredits());
        return true;
    }

}
