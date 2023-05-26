package controller;

import model.Account;
import model.AccountType;
import model.LoanKind;
import model.Transaction;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController {
    public static void start(){
        while(true){
            try {
                ServerSocket serverSocket = new ServerSocket(7744);
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread{

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientHandler(Socket socket){
        this.socket = socket;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(socket.isConnected()){
           
            try {
                String request = dataInputStream.readUTF();
                processRequest(request);
            }catch (IOException e){
                System.out.println("Connection error occurred!");
                e.printStackTrace();
                break;
            }
            DataController.saveData();
        }
        System.out.println("closed");
        closeClient();
        
    }

    private void processRequest(String request){
        String[] requestParts = request.split(",");
        if (requestParts[0].equals("0"))
            registerUser(requestParts);
        if (requestParts[0].equals("1"))
            loginUser(requestParts);
        if (requestParts[0].equals("2"))
            registerNewAccount(requestParts);
        if (requestParts[0].equals("3.0"))
            getAccountInformation(requestParts);
        if (requestParts[0].equals("3.1"))
            getUserAccountIds(requestParts);
        if (requestParts[0].equals("3.2"))
            getAccountTransactions(requestParts);
        if (requestParts[0].equals("4"))
            exchange(requestParts);
        if (requestParts[0].equals("5"))
            payReceipt(requestParts);
        if (requestParts[0].equals("6"))
            getLoan(requestParts);
        if (requestParts[0].equals("7"))
            closeAccount(requestParts);
        if(requestParts[0].equals("8"))
            setUsefulAccount(requestParts);
        if(requestParts[0].equals("9"))
            setAlias(requestParts);
    }

    private void registerUser(String[] requestParts){
        if (!UserController.registerUser(requestParts[1],requestParts[2],requestParts[3],requestParts[4],requestParts[5]))
            sendData("error");
        else
            sendData("success");
    }
    private void setAlias(String[] requestParts){
        Account account = AccountsController.getAccountById(Integer.parseInt(requestParts[1]));
        if(account != null){
        account.setAlias(requestParts[2]);
        sendData("success");
        }
        else{
            sendData("error");
        }
        }
    private void setUsefulAccount(String[] requestParts){
        Account account = AccountsController.getAccountById(Integer.parseInt(requestParts[1]));
        if (account != null ){
        UserController.getLoggedUser().addUsefulAccount(account);
        sendData("success");
        }
        else{
            sendData("error");
        }
    }
    private void loginUser(String[] requestParts){
        if (UserController.loginUser(requestParts[1],requestParts[2]))
            sendData("success");
        else
            sendData("error");
    }

    private void registerNewAccount(String[] requestParts){
        AccountType accountType;
        if (requestParts[1].equals("LONG"))
            accountType = AccountType.LONG_TERM;
        else
            accountType = AccountType.SHORT_TERM;
        String password = requestParts[2];
        if (UserController.getLoggedUser() == null)
            sendData("error");
        else {
            AccountsController.createNewAccount(password,UserController.getLoggedUser(),accountType);
            sendData("success");
        }
    }

    private void getAccountInformation(String[] requestParts){
        Account account = AccountsController.getAccountById(Integer.parseInt(requestParts[1]));
        if (account == null || !account.getPassword().equals(requestParts[2]) ){
            sendData("error");
            return;
        }
        String response = "Balance: " + account.getBalance() + "\n" + "Account Password: " + account.getPassword() + "\n" + "Alias: " + account.getAlias() + "\n";
        if (account.getAccountType().equals(AccountType.LONG_TERM))
            response += "Kind: LONG\n";
        else
            response += "Kind: SHORT\n";
        response += account.getOwner().getNationalCode();
        sendData(response);
    }

    private void getUserAccountIds(String[] requestParts){
        if (UserController.getLoggedUser() == null)
            sendData("error");
        else{
            ArrayList<Account> accounts = null;
            if (requestParts[1].equals("0"))
                accounts = AccountsController.getUserAllAccounts(UserController.getLoggedUser());
            else
                accounts = AccountsController.getUsefulAccounts(UserController.getLoggedUser());
            String response = "";
            for(int i = 0;i<accounts.size();++i){
                response += accounts.get(i).getId();
                if (i != accounts.size()-1)
                    response += ",";
            }
            sendData(response);
        }
    }

    private void getAccountTransactions(String[] requestParts){
        Account account = AccountsController.getAccountById(Integer.parseInt(requestParts[1]));
        if (account == null ){
            sendData("error");
            return;
        }
        ArrayList<Transaction> transactions = AccountsController.getAccountTransactions(account);
        String response = "";
        for(int i = 0;i<transactions.size();++i){
            Transaction transaction = transactions.get(i);
            response += transaction.getBalance() + "|" + transaction.getDescription();
            if (i<transactions.size()-1)
                response += ",";
        }
        sendData(response);
    }

    private void exchange(String[] requestParts){
        int amount = Integer.parseInt(requestParts[1]);
        int sourceAccountId = Integer.parseInt(requestParts[2]);
        int destinationAccountId = Integer.parseInt(requestParts[3]);
        if (AccountsController.exchangeMoney(AccountsController.getAccountById(sourceAccountId ),
                AccountsController.getAccountById(destinationAccountId),amount)){
         if(AccountsController.getAccountById(sourceAccountId ).getPassword().equals(requestParts[4]))   
            sendData("success");
        }
        else
            sendData("error");
    }

    private void payReceipt(String[] requestParts){
        int accountId = Integer.parseInt(requestParts[1]);
        int amount = Integer.parseInt(requestParts[2]);
        Account account = AccountsController.getAccountById(accountId);
        if (AccountsController.payReceipt(account,amount) && account.getPassword().equals(requestParts[3]))
            sendData("success");
        else
            sendData("error");
    }

    private void getLoan(String[] requestParts){
        int accountId = Integer.parseInt(requestParts[1]);
        Account account = AccountsController.getAccountById(accountId);
        int amount = Integer.parseInt(requestParts[2]);
        LoanKind loanKind = null;
        if (requestParts[3].equals("MONTHLY"))
            loanKind = LoanKind.MONTHLY;
        if (requestParts[3].equals("WEEKLY"))
            loanKind = LoanKind.WEEKLY;
        if (requestParts[3].equals("DAILY"))
            loanKind = LoanKind.DAILY;
        if (AccountsController.getLoan(account,amount,loanKind))
            sendData("success");
        else
            sendData("error");
    }

    private void closeAccount(String[] requestParts){
        Account closingAccount = AccountsController.getAccountById(Integer.parseInt(requestParts[1]));
        String password = requestParts[2];
        Account supportAccount = AccountsController.getAccountById(Integer.parseInt(requestParts[3]));
        if (!closingAccount.getPassword().equals(password)) {
            sendData("error");
            return;
        }
        if (AccountsController.removeAccount(closingAccount,supportAccount))
            sendData("success");
        else
            sendData("error");
    }

    private void sendData(String data){
        try {
            DataController.saveData();
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
         
        }catch (IOException e){
            System.out.println("a transferring problem occurred");
            e.printStackTrace();
        }
    }

    private void closeClient(){
        try {
            socket.close();
            dataOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}