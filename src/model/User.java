package model;

import java.util.ArrayList;

public class User {
    private String name;
    private String nationalCode;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private ArrayList<Integer> usefulAccounts;

    public User(String name, String nationalCode, String password, String phoneNumber, String emailAddress) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        usefulAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Integer> getUsefulAccounts() {
        return usefulAccounts;
    }

    public void addUsefulAccount(Account account){
        for(Integer usefulAccountId:usefulAccounts){
            if (usefulAccountId == account.getId())
                return;
        }
        usefulAccounts.add(account.getId());
    }

    public void removeUsefulAccount(Account account){
        for(Integer usefulAccountId:usefulAccounts){
            if (usefulAccountId == account.getId()) {
                usefulAccounts.remove(usefulAccountId);
                return;
            }
        }
    }
}
