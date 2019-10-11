import java.util.*;
import java.io.*;

public class maxcross {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("maxcross.in"));
        // 2 10 1 5 9
        // 1 2* 3 4 5* 6 7 8 9* 10*
        int n = sc.nextInt(); int k = sc.nextInt(); int b = sc.nextInt();
        int arr[] = new int[n];
        int min = Integer.MAX_VALUE;
        int windowSum = 0;
        
        for(int i = 0; i < b; i++) {
            arr[sc.nextInt() - 1] = 1;
        }
        for(int i = 0; i < k; i++) {
            if(arr[i] == 1)
                windowSum++;
        }
        for(int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            min = Math.min(windowSum, min);
        }
        System.out.println(min);
        PrintWriter pw = new PrintWriter(new File("maxcross.out"));
        pw.println(min);
        pw.close();
    }
}
