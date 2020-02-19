import java.util.*;
import java.io.*;

/**
 * @author Eric K. Zhang
 */
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.parseInt(br.readLine());
        String[] ingr = new String[N];
        for (int i = 0; i < N; i++)
            ingr[i] = br.readLine();

        int[][] dp = new int[N + 1][N + 1];
        for (int s = N - 1; s >= 0; s--) {
            for (int e = s + 1; e <= N; e++) {
                dp[s][e] = dp[s + 1][e] + 1;
                for (int k = s + 1; k < e; k++)
                    if (ingr[s].equals(ingr[k]))
                        dp[s][e] = Math.min(dp[s][e], dp[s + 1][k] + dp[k][e]);
            }
        }

        out.println(dp[0][N]);
        out.flush();
    }
}
