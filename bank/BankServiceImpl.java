package bank;

public class BankServiceImpl implements BankService {
    @Override
    public Double addFundsToAccount(Account accountObjRef, Double amount) throws CustomNullException {
        if(accountObjRef == null){
            throw new CustomNullException("no account found");
        }
        if(amount<0){
            System.out.println("Amount must be greater than one");
            return null;
        }
        accountObjRef.setBalance(accountObjRef.getBalance()+amount);
        return accountObjRef.getBalance();
    }

    @Override
    public Double withdrawFundsFromAccount(Account account, Double amount) throws CustomNullException {
        if(account == null) {
            throw new CustomNullException("no account found");
        }
        if(account.getBalance() < amount){
            System.out.println("Amount is insufficient");
            return null;
        }
        account.setBalance(account.getBalance()-amount);
        return account.getBalance();
    }

    @Override
    public Boolean fundTransfer(Account fromAccount, Account toAccount, Double amount) throws CustomNullException {
        if(fromAccount == null || toAccount == null){
            throw new CustomNullException("no account found");
        }
        assert fromAccount != null;
        if(amount > fromAccount.getBalance()){
            System.out.println("insufficient funds");
            return false;
        }
        try {
            withdrawFundsFromAccount(fromAccount,amount);
        } catch (CustomNullException e) {
            System.out.println(e.getMessage());
        }
        try {
            addFundsToAccount(toAccount,amount);
        } catch (CustomNullException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public void displayAccountInfo() {

    }
}
