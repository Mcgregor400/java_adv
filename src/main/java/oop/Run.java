package oop;

import oop.model.User;
import oop.model.enums.Gender;

public class Run {
    public static void main(String[] args) {
        User ul = new User("Adam","Kowalski","ghys@wp.pl","123","885447184", Gender.MAN);
        System.out.println(ul);
    }
}
