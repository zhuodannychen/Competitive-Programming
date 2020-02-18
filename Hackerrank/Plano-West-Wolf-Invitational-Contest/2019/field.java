import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[r*c];
        int max = 0;
        for(int i = 0; i < r*c; i++)
        {
            arr[i] = sc.nextInt();
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println(max);
    }
}
