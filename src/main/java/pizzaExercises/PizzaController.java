package pizzaExercises;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PizzaController {
    //metoda zwracająca cenę
    public int calculatePizzaPrice (Pizza pizza){
   return      pizza.getIngredients().stream()
                .mapToInt(p->p.getPrice())
                .sum();

    }
    //METODA zwracająca tylko pizze ostre
    public List<Pizza> getAllSpice(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .collect(Collectors.toList());
    }

    //metoda zwracjąca obiekt Pizza dla najtańszej i ostrej pizz
    public Pizza findCheapstSpicy(){
       // return Arrays.stream(Pizza.values())
        Optional<Pizza> pizzaOpt = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza))) //sortowanie MIN Max
                .limit(1)
                .findFirst();
                if(pizzaOpt.isPresent()){
                    return pizzaOpt.get();
                }
        System.out.println("Brak danych do pobrania");
                return null;
    }
    //metoda wpisująca pizzze wraz z cenami
    public void getAllPizzasWithPrices(){
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName()+ "-"+calculatePizzaPrice(pizza)+"PLN"));
    }
    //metoda zwracająca najdroższą pizze Vegetariańską
   public Pizza FindMostExpenciveVegetarian(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().noneMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(this::calculatePizzaPrice).reversed())
                .findFirst().get();
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("Cena: " + pc.calculatePizzaPrice(Pizza.MARGHERITA));
        System.out.println("Ostre ");
        pc.getAllSpice().forEach(System.out::println);
        System.out.println("PIZZE Z CENAMI");
        pc.getAllPizzasWithPrices();
        System.out.println("Najtańsza pizza ostra");
        System.out.println(pc.findCheapstSpicy());
        System.out.println("Najdroższa pizza WEGE");
        System.out.println(pc.FindMostExpenciveVegetarian());
    }
}
