package model;

public class Transaction {
    private final Account account;
    private final int balance;
    private String description;
    private boolean isApplied;

    public Transaction(Account account,int balance){
        this.account = account;
        this.balance = balance;
        description = "-";
        apply();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void apply(){
        if (!isApplied) {
            synchronized (account) {
                account.changeBalance(balance);
            }
        }
        isApplied = true;
    }

    public String getDescription() {
        return description;
    }

    public Account getAccount() {
        return account;
    }

    public int getBalance() {
        return balance;
    }
}
