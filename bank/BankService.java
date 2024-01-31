package bank;

public interface BankService {
    Double addFundsToAccount(Account accountObjRef, Double amount) throws CustomNullException;
    Double withdrawFundsFromAccount(Account account,Double amount) throws CustomNullException;
    Boolean fundTransfer(Account fromAccount,Account toAccount, Double amount) throws CustomNullException;
    void displayAccountInfo();
}
