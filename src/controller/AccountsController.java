package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AccountsController {
    private static ArrayList<Account> accounts;

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        AccountsController.accounts = accounts;
    }

    public static synchronized void createNewAccount(String password, User user, AccountType accountType){
        accounts.add(new Account(password,user,accountType));
    }

    public static synchronized int getFirstFreeId(){
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getId() - o2.getId();
            }
        });
        for(int i = 0;i<accounts.size();++i){
            if (accounts.get(i).getId() != i+1)
                return i+1;
        }
        return accounts.size()+1;
    }

    public static synchronized void addAccountToUsefulAccounts(Account account,User user){
        user.addUsefulAccount(account);
    }

    public static synchronized ArrayList<Account> getUsefulAccounts(User user){
        ArrayList<Account> usefulAccounts = new ArrayList<>();
        for(Integer accountId:user.getUsefulAccounts())
            usefulAccounts.add(getAccountById(accountId));
        return usefulAccounts;
    }

    public static synchronized ArrayList<Account> getUserAllAccounts(User user){
        ArrayList<Account> userAccounts = new ArrayList<>();
        for(Account account:accounts){
            if (account.getOwner().getNationalCode().equals(user.getNationalCode()))
                userAccounts.add(account);
        }
        return userAccounts;
    }

    public static synchronized Account getAccountById(int id){
        for(Account account:accounts){
            if (account.getId() == id)
                return account;
        }
        return null;
    }

    public static synchronized ArrayList<Transaction> getAccountTransactions(Account account){
        ArrayList<Transaction> transactions = new ArrayList<>();
        for(Transaction transaction:TransactionController.getTransactions()){
            if (transaction.getAccount().equals(account))
                transactions.add(transaction);
        }
        return transactions;
    }

    public static synchronized boolean exchangeMoney(Account sourceAccount,Account destinationAccount,int amount){
        if (sourceAccount == null || destinationAccount == null)
            return false;
        Transaction takingMoneyTransaction = new Transaction(sourceAccount,-amount);
        Transaction puttingMoneyTransaction = new Transaction(destinationAccount,amount);
        TransactionController.addTransaction(takingMoneyTransaction);
        TransactionController.addTransaction(puttingMoneyTransaction);
        return true;
    }

    public static synchronized boolean payReceipt(Account account,int amount){
        if (account == null)
            return false;
        Transaction transaction = new Transaction(account,-amount);
        transaction.setDescription("Receipt");
        TransactionController.addTransaction(transaction);
        return true;
    }

    public static synchronized boolean getLoan(Account account,int amount,LoanKind kind){
        if (account == null)
            return false;
        Loan loan = new Loan(amount,kind);
        synchronized (account) {
            account.addLoan(loan);
        }
        return true;
    }

    public static synchronized boolean removeAccount(Account account,Account supportAccount){
        if (account == null || supportAccount == null)
            return false;
        if (account.getBalance() != 0)
            exchangeMoney(account,supportAccount,account.getBalance());
        accounts.remove(account);
        return true;
    }

}