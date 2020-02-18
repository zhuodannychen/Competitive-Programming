import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int max = 0;
        int[] dp = new int[N];
        int[] vals = new int[N];
        for (int i = 0; i < N; ++i) {
            vals[i] = scanner.nextInt();
            dp[i] = 1;
            for (int j = i - 1; j >= 0; --j)
                if (vals[j] >= vals[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}