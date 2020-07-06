package oop.controller;
//klasa kontrollera - odpowiedzialna za obsługę i implementację logiki biznsowej metod użytkownika logiki biznesowej apliikkacji

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

public class UserController implements UserControllerTempl {
    private String passwordEncoder(String password) {
        try {
            //Obiekt do szyfrowania hasła algorytmem MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordHash = md.digest(password.getBytes());
            //zapisanie tablicy liczb w typie String
            String passwordHashTxt = "";
            for (byte digit : passwordHash) {
                passwordHashTxt += String.format("%x", digit);
            }
            return passwordHashTxt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override //adnotacja przysłanianie metody
    public void registerUser(User user) throws NoSuchAlgorithmException {
        //kodowanie hasła
        //Aktualizacja hasła w modelu user
        user.setPassword(passwordEncoder(user.getPassword()));
        users.add(user);
        System.out.println("Dodano nowego użytkownika: " + user.getEmail());

    }

    @Override
    public boolean loginUser(String email, String password) {
        for (User user : users) {
            //porównianie e-maila i shshów haseł
            if (user.getEmail().equals(email) && user.getPassword().equals((passwordEncoder(password)))) {
                System.out.println("Zalogowano użytkownika: " + user.getEmail());
                return true;
            }
        }
        return false;
    }
    @Override
    public User findUserById(int userId) {
        for(User user : users){
            if(user.getUserId() == userId){
                System.out.println("Znaleziono użytkownika : " + user);
                return user;
            }
        }
        System.out.println("Nie znaleziono użytkownika o id=" + userId);
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        for (User user : users) {
        }
        return users;
    }







    @Override
    public void updateUserPassword(int userId, String newPassword) {

    }

    @Override
    public void deleteUserById(int userId) {

    }

    @Override
    public void updateRole() {

    }

    @Override
    public void updateRole(int userId, Set<Role> newRoles) {

    }



    @Override
    public List<User> findAllUsersOrderByArg(UserField userField, boolean asc) {
        return null;
    }
}
