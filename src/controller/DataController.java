package controller;

import com.google.gson.Gson;
import model.Account;
import model.Transaction;
import model.User;
import java.nio.charset.StandardCharsets;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    public static synchronized void loadData(){
        loadUsers();
        loadAccounts();
        loadTransactions();
    }

    public static synchronized void saveData(){
        writeJson(new Gson().toJson(UserController.getUsers()),"users");
        for(Account account:AccountsController.getAccounts())
            account.getBalance();
        writeJson(new Gson().toJson(AccountsController.getAccounts()),"accounts");
        writeJson(new Gson().toJson(TransactionController.getTransactions()),"transactions");
    }
    
    private static synchronized void loadUsers(){
        ArrayList<User> users = new ArrayList<>();
        User[] usersArray = new Gson().fromJson(loadJson("users"),User[].class);
        if (usersArray != null){
            for(int i = 0;i<usersArray.length;++i)
                users.add(usersArray[i]);
        }
        UserController.setUsers(users);
    }

    private static synchronized void loadAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        Account[] accountsArray = new Gson().fromJson(loadJson("accounts"),Account[].class);
        if (accountsArray != null){
            for(int i = 0;i<accountsArray.length;++i)
                accounts.add(accountsArray[i]);
        }
        AccountsController.setAccounts(accounts);
    }

    private static synchronized void loadTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction[] transactionsArray = new Gson().fromJson(loadJson("transactions"),Transaction[].class);
        if (transactionsArray != null){
            for(int i = 0;i<transactionsArray.length;++i)
                transactions.add(transactionsArray[i]);
        }
        TransactionController.setTransactions(transactions);
    }

    private static void writeJson(String json,String filename){
        FileWriter writer = null;
        System.out.println(json);
        try {
            writer = new FileWriter( filename + ".json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String loadJson(String filename){
        Path filePath = Paths.get(filename + ".json");
        if (!Files.exists(filePath))
            return "null";
        String json = "null";
       try {
           json = "";
           List<String> list = Files.readAllLines(filePath);
           for(String s:list)
               json +=s;
            System.out.println(json);
        } catch (IOException e) {
           System.exit(0);
        }
        return json;
    }

}
