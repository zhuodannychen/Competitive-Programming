import java.util.*;
import java.io.*;

public class PowerProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int maxDiff = arr[1] - arr[0];
        int min = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] - min > maxDiff)
                maxDiff = arr[i] - min;
            if(arr[i] < min)
                min = arr[i];
        }
        if(maxDiff < 0)
            System.out.println(0);
        else
            System.out.println(maxDiff);
    }
}
