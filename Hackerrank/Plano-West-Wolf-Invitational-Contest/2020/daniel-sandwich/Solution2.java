import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dp = new int[N + 1][N + 1];
        String[] items = new String[N + 1];
        
        for (int i = 1; i <= N; ++i) {
            items[i] = scanner.next();
            dp[i][i] = 1;
            for (int j = i - 1; j > 0; --j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 1; k >= j; --k) {
                    int val = items[i].equals(items[k]) ? 0 : 1;
                    val += dp[i - 1][k] + dp[k - 1][j];
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        
        System.out.println(dp[N][1]);
    }
}
