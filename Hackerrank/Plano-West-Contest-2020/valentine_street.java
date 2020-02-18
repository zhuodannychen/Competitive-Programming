import java.io.*;
import java.util.*;

public class valentine_street {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();
        int[] loc = new int[n];
        for (int i = 0; i < n; i++)
            loc[i] = sc.nextInt();
        Arrays.sort(loc);
        int ans = 0;
        for (int i = n-1; i >= 0; i-=k) {
            ans += 2 * (loc[i] - 1);
        }
        System.out.println(ans);
    }
}
