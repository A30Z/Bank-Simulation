package controller;

import model.Transaction;

import java.util.ArrayList;

public class TransactionController {
    private static ArrayList<Transaction> transactions;

    public static synchronized ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(ArrayList<Transaction> transactions) {
        TransactionController.transactions = transactions;
    }

    public static synchronized void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
