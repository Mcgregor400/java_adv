package oop.controller;
//Interfejs -> czyli szablon wymagań dla klasy go implementującej

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface UserControllerTempl {
    //pole statyczne finalne
    List<User> users = new ArrayList<>(
        Arrays.asList(
      new  User("Adam","Kowalski","ghys@wp.pl","123","885447184",Gender.MAN)
                )
    );

    //metoda abstrakcyjna ->metoda nie posiadająca ciała - implementacji -> sygnatura metody
    //[typ zwacanej wartości / void] [nazwa metody]  ([argunety/ bez argumentów]);
    //rejestracja
    public void registerUser(User user) throws NoSuchAlgorithmException;
    //logowanie
    boolean loginUser (String email, String password);
    //wyszukiwanie
    User findUserById(int userId);
    //update password
    void updateUserPassword(int userId, String newPassword);
    //delete user
    void  deleteUserById(int userId);
    //add/drop role
    void updateRole();
    void updateRole(int userId, Set<Role> newRoles);
    //wypisanie wszystkich użytkowników
    List<User> findAllUsers();
    //wypisanie użytkowników posortowanych po argumencie
    List<User> findAllUsersOrderByArg(UserField userField, boolean asc);



}
