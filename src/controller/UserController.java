package controller;

import model.User;

import java.util.ArrayList;

public class UserController {
    private static User loggedUser;
    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UserController.users = users;
    }

    public static void logoutUser(){
        loggedUser = null;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static boolean loginUser(String nationalCode, String password){
        for(User user:users){
            if (user.getNationalCode().equals(nationalCode) && user.getPassword().equals(password)){
                loggedUser = user;
                return true;
            }
        }
        return false;
    }

    public static boolean registerUser(String fullName,String nationalCode,String password,String phoneNumber,String emailAddress){
        for(User user:users){
            if (user.getNationalCode().equals(nationalCode))
                return false;
        }
        users.add(new User(fullName,nationalCode,password,phoneNumber,emailAddress));
        return true;
    }

}