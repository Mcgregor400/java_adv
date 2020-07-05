package colections;

import javax.swing.tree.AbstractLayoutCache;
import javax.xml.namespace.QName;
import java.sql.Array;
import java.util.*;

public class JacaCollectionsExample {

    List<String> names = new ArrayList<>(Arrays.asList("Jan","Ala","Ola"));
    public void arrayOperations() {
        //pola globalne
        try {
            //utworzenie tablicy 10-cio elementowej
            String[] names = new String[10];
            int[] numbers = {1, 2, 3, 4};
            Arrays.stream(names) //zmiana tablicy na stream
                    .forEach(s -> System.out.println(s));//dla każdego elementu wykonaj predykat (CTRL + sPACE)

            System.out.println("Tablica liczb: ");
            Arrays.stream(numbers).forEach(n -> System.out.print(n + ","));
            System.out.println("Modyfikacja wartości na indeksie");
            names[5] = "Anna";
            names[names.length - 1] = "Adam";
            names[100] = "Jan";   //ArrayIndexOutOfBoundsException
            Arrays.stream(names).forEach(s -> System.out.println(s + ","));
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Błąd indeksowania tablicy");
        }
        System.out.println("Poza try catchem");
    }
    public void ListOperation(){
        //utworzenie pustej listy
        List<String> names = new ArrayList<>();
        //utworzenie listy zinicjowanej wartościami
        List<Double> params = new ArrayList<>(Arrays.asList(1.2,1.3,2.55,3.44));
        System.out.println(names);
        System.out.println(params);
    }
    public boolean findElement(List<String>names,String name){
        return names.contains(name);
    }
    public  void removeElement(String name){
        List<String> names = new ArrayList<>(Arrays.asList("Jan","Ala","Ola"));
        System.out.println();
        names.remove(name);
        System.out.println();

    }
    public  void removeAllElements(String name){

        System.out.println();
        names.removeAll(Arrays.asList(name));
        System.out.println();

    }
    // zmień piewrszy i ostatni element na Adam w liście names
    public void updateFirstAndLastElement(String name){
        names.set(0, name);
        names.set(names.size() - 1, name);
        System.out.println(names);
    }
    //zmień pierwszy i ostatni element na Adam w liście names
    public void getAllElementsWithOddIndex(String name){
        names.set(0,name);
        names.set(names.size()-1,name);
        System.out.println(names);
    }
    //wypisz wszystkie elementy znajdujące się na parzystych indeksach listy names
    public void getAllElementsWithOddIndex(){
        for (int i =0;i<names.size(); i=i+2){
            System.out.println(names.get(i) + " ");
        }
    }
    private Set<String> roles1 = new HashSet<>(Arrays.asList("admin","user"));
    private Set<String> roles2 = new HashSet<>(Arrays.asList("user","viewer", "moderator"));
    //jakie mamy role w serwisie www
    public Set<String> getAllRoles(){
        //utworzenie pustego podręcznego zbiou z widocznością tylko w obrębie metody
        Set<String>allRoles = new HashSet<>();
        allRoles.addAll(roles1);
        allRoles.addAll(roles2);
        return allRoles;
    }
    //jakie role się powtarzają w obu zbiorach
    public Set<String> getNonUniqueRoles(){
        Set<String>noUniqueRoles = new TreeSet<>();
        noUniqueRoles.addAll(roles1);
        noUniqueRoles.addAll(roles2);
        return noUniqueRoles;
    }
   //wypisz wszystkie unikatowe elementy obu zbiorów
   public Set<String> getUniqueRoles(){
    Set<String> uniqueRoles = getAllRoles();
    uniqueRoles.removeAll(getNonUniqueRoles());
    return uniqueRoles;
   }
   private Map<Integer,String> decimalToRoman = new HashMap<>();
    private Map<String, Integer> romanToDecimal = new HashMap<>();
    public void generateValusesIntoMap(){
        decimalToRoman.put(0,"0");
        decimalToRoman.put(1,"I");
        decimalToRoman.put(2,"II");
        decimalToRoman.put(3,"III");
        decimalToRoman.put(4,"IV");
        decimalToRoman.put(5,"V");
        System.out.println(decimalToRoman);
    }
    public void generateMapRomanToDecimal(){
        for (Integer key:decimalToRoman.keySet()){
            decimalToRoman.put(key, decimalToRoman.get(key));
        }
        System.out.println(decimalToRoman);
    }
    private Deque<String> messages = new ArrayDeque<>();


    public void sendMessage(String message){
        messages.addLast(message);
        System.out.println(messages);
    }

    public  void reciveMessage() {
        try {

            while (!messages.isEmpty()) {
                System.out.println("Odebrano wiadomość: " + messages.removeFirst());
                System.out.println("Pozostałe wiadomości: " + messages);

                Thread.currentThread().sleep(1000); //uśpienie programu na 1000ms
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
//************************************************************************
    public static void main(String[] args){
            JacaCollectionsExample ex = new JacaCollectionsExample();
          //  ex.arrayOperations();
        ex.ListOperation();

        ex.findElement(new ArrayList<>(Arrays.asList("Jan","Ala","Ola","ela")), "Ala");
        ex.removeElement("Ala");
        ex.removeAllElements("Ala");
        ex.updateFirstAndLastElement("x");
        ex.getAllElementsWithOddIndex();
        System.out.println("\nAll roles: "+ ex.getAllRoles());
        System.out.println("Unique roles: " + ex.getNonUniqueRoles());
        System.out.println("\nAll roles: "+ ex.getUniqueRoles());
        ex.generateValusesIntoMap();
        System.out.println("5 dziesętna to: " +ex.decimalToRoman.get(5));
        System.out.println("II dziesętna to: " +ex.romanToDecimal.get("II"));
        ex.sendMessage("Pierwsza wiadomość");
        ex.sendMessage("Druga wiadomość");
        ex.sendMessage("Trzecia wiadomość");
        ex.sendMessage("Czwarta wiadomość");
        ex.reciveMessage();
        }
}
