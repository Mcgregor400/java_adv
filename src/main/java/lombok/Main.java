package lombok;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //sprawedznie konstruktorów
        User userNoArgs = new User();
        User userAllArgs = new User(1,"Test@test.pl", "test", LocalDateTime.now(),true,false);
        //testgetterów i setterów
        userNoArgs.setPassword("Nowe hasło");
        userNoArgs.setRegistrationDateTima(LocalDateTime.of(2000,2,10,16,16,11));
        userAllArgs.setStatus(false);
        System.out.println("nowe hasło użytkownika to : " + userNoArgs.getPassword());
        System.out.println("Nowy status użytkownika to: " + userAllArgs.isStatus());
        System.out.println("Nowa data rejestracji to: " + userNoArgs.getRegistrationDateTima());
        //SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy (HH:mm)");
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy'r.' '('HH:m')'");
        //System.out.println("Sformatowana data rejestracji to: " + sdf.format(userNoArgs.getRegistrationDateTima()));
        System.out.println("Sformatowana data rejestracji to: " + dtf.format(userNoArgs.getRegistrationDateTima()));
        System.out.println("Taski");
        Task task = new Task();
        Task task1 = new Task("Nauka Javy","programowanie obiektowe",false,userAllArgs);
        System.out.println(task);
        System.out.println(userAllArgs);
        System.out.println(userAllArgs);
    }
}
