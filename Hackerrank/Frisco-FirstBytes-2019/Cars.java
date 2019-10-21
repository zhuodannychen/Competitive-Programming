import java.io.*;
import java.util.*;

public class Cars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int i = 0;
        int current = sc.nextInt();
        while(i < n - 1) {
            int s = sc.nextInt();
            if(current > s){
                count++;
                current = s;
                i++;
            }else{
                i++;
            }
        }
        System.out.println(count);
    }
}
