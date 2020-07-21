package anonymousClasses;
//klasa anonimowa nie posiada nazwy można utworzyć tylko jedną jej instancję
//nie można się  do niej później odwołć
public class Main {
    public static void main(String[] args) {
       Object object = new EventController() {
           @Override
           public void printEvent() {
               System.out.println("--Nowe wydarzenie--");
               EventController.formattedEventDate();

           }
           };
        ((EventController)object).printEvent();
       }
}
