import java.io.*;
import java.util.*;

public class candy_tower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++)
            l[i] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (l[i] <= l[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
