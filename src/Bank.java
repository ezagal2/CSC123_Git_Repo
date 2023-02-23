import java.util.ArrayList;

public class Bank {
    private static ArrayList<Account> accounts=new ArrayList<Account>();
    private static int accountNumbers=100;
    private Bank() {}

    public static Account openAccount(String firstName, String lastName, String email, String SSN, String accountType) {
        Person customer=new Person(firstName, lastName,email,SSN);
        Account account=new Account(accountNumbers++, accountType, customer);
        accounts.add(account);
        return account;

    }

    public static void printAccounts() {

        for(Account a: accounts) {
            System.out.println(a);
        }

    }
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.toString().contains(String.format("%d", accountNumber))) {
                return account;
            }

        }
        return null;
     }

     public boolean deposit(int accountNumber, double amount) {
        if (findAccount(accountNumber) == null){ return false; }
        return findAccount(accountNumber).deposit(amount);
     }

     public boolean withdraw(int accountNumber, double amount) {
        if (findAccount(accountNumber) == null){ return false; }
        return findAccount(accountNumber).withdraw(amount);
     }


     public boolean closeAccount(int accountNumber) {
         if (findAccount(accountNumber) == null){ return false; }
         findAccount(accountNumber).closeAccount();
         return true;
     }

}
