package oop;

import oop.controller.InputOutputController;
import oop.controller.UserController;
import oop.controller.UserControllerTempl;
import oop.model.User;
import oop.model.enums.Gender;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Run extends InputOutputController {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        User ul = new User("Adam","Kowalski","ghys@wp.pl","123","885447184", Gender.MAN);
//        System.out.println(ul);
//        for(User user: UserControllerTempl.users){
//
//          // System.out.println(user);
//    }
//        UserControllerTempl.users.forEach(user -> System.out.println(user));
        //1 wywoałanie obikty klasy UserController
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        List<User> users = UserControllerTempl.users;
        while (true) {
            System.out.println("Co chcesz zroić? \n1.Rejestracja \n2.Lista użytkowników  \n3.Szukaj użytkownika \nQ. Wyjście");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("1")) {
                System.out.println("Podaj imię: ");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email: ");
                String email = scanner.nextLine();
                System.out.println("Podaj hasło: ");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K): ");
                String genderInput = scanner.nextLine().toUpperCase();
                Gender gender = genderInput.equals("M")? Gender.MAN:Gender.WOMAN;
                System.out.println("Podaj telefon 000-000-000) : ");
                String phone = scanner.nextLine();
                //walidacja na podstawie regex-ów
                String phonePateern = "^[0-9]{3}(-[0-9]{3}){2}$";
                String genderPattern = "^[MK]{1}$";
                String emailPattern = "^\\S{1,}[@]\\S{1,}$";

                if (!Pattern.matches(phonePateern,phone)){
                    System.out.println("Błędny numer telefonu!");
                    continue;
                }
                if(!Pattern.matches(genderPattern,genderInput)){
                    System.out.println("Błędnie wprowadzona płeć");
                    continue;
                }
                if (!Pattern.matches(emailPattern, email)){
                    System.out.println("Błędny adres e-mail");
                    continue;
                }

                uc.registerUser(new User(name, lastName, email, password, phone, gender));

            } else if (choice.equals("2")) {
                uc.findAllUsers().forEach(user -> System.out.println(user));

            } else if (choice.equals("Q")) {
                System.out.println("Wyjście");
                break;
            }

        }
    }
}

