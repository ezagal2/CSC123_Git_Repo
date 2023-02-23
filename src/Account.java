public class Account {
    //Fields

    private int accountNumber;
    private String type;
    private boolean accountOpen;
    private double balance;
    private Person accountHolder;

    //Constructor
    public Account(int accountNumber, String type, Person accountHolder) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.accountHolder = accountHolder;
        accountOpen=true;
    }


    public boolean withdraw(double amount) {
        if(this.balance-amount<0) return false;
        this.balance=this.balance-amount;
        return true;
    }

    public boolean deposit(double amount) {
        if(amount<0 || !isOpen()) return false;
        this.balance=this.balance+amount;
        return true;

    }

    public boolean isOpen() {
        return this.accountOpen;
    }

    public void closeAccount() {
        this.accountOpen=false;
    }

    public double getBalance() {
        return this.balance;
    }


    public String toString() {
        return this.accountNumber+":"+type+":"+this.balance+":["+this.accountHolder.toString()+"]";
    }

}
