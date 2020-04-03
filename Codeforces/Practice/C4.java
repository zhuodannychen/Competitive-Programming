import java.util.*;

public class RegistrationSystem {
 
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Map<String, Integer> dataBase = new HashMap<>();
       int cases = sc.nextInt();
       sc.nextLine();
       for(int i=0;i<cases;i++){
           String input = sc.nextLine();
           if(dataBase.containsKey(input)){
               int x = dataBase.get(input);
               x++;
               dataBase.put(input, x);
               System.out.println(input+x);
           }
           else{
               System.out.println("OK");
               dataBase.put(input,0);   
           }
       }
    }   
}
