package bank;

public class Client {
    public static void main(String[] Args){
        Account firstAccount = new Account(1,"Ford",5_00_000.0);
        Account secondAccount = new Account(2,"Toyota",10_00_000.0);
        //BankServiceImpl bankService = new BankServiceImpl(); // tight coupling
        BankService bankService = new BankServiceImpl();
        System.out.println(firstAccount);
        System.out.println(secondAccount);
        try {
            bankService.addFundsToAccount(null,1000.0);
        } catch (CustomNullException e) {
            System.out.println(e.getMessage());
        }
        try {
            bankService.fundTransfer(firstAccount,null,4_99_999.0);
        } catch (CustomNullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(firstAccount);
        System.out.println(secondAccount);
    }
}
