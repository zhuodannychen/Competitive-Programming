import java.util.*;
import java.io.*;

public class Prob05 {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int num = reader.nextInt();
        for (int i = 0; i<num; i++){
            int ones = reader.nextInt();
            int fives = reader.nextInt();
            int target = reader.nextInt();
            int remain = target % 5;
            if (5 * fives + ones == target){
                System.out.println("true");
            }
           else if (5 * fives < target && 5 * fives + ones >= target){
                System.out.println("true");
            }
           else if (5 * fives >= target && ones >= remain){
                System.out.println("true");
            }
           else if (5 * fives == target){
                System.out.println("true");
            }
           else if (ones >= target){
                System.out.println("true");
            }
           else if (target == 0){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }

        }
    }
}
