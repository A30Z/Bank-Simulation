package model;

import controller.AccountsController;

import java.util.ArrayList;

public class Account {

    private String password;
    private String alias;
    private int id;
    private User owner;
    private int balance;
    private ArrayList<Loan> loans;
    private AccountType accountType;

    public Account(String password,User user,AccountType accountType){
        this.password = password;
        this.owner = user;
        this.accountType = accountType;
        id = AccountsController.getFirstFreeId();
        loans = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        for(Loan loan:loans)
            loan.pay(this);
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void changeBalance(int amount){
        balance += amount;
    }

    public void addLoan(Loan loan){
        loans.add(loan);
    }

    public User getOwner() {
        return owner;
    }
}
