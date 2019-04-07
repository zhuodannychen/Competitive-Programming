import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            int A = sc.nextInt(); int B = sc.nextInt();
            int count = 1;
            while(A * B > count*count){
                count++;
            }
            System.out.println(count*count);
        }
    }
}
