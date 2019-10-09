import java.io.*;
import java.util.*;

public class CrossingSwampland {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int id = sc.nextInt(); int N = sc.nextInt();
            long[][] dp = new long[N][N];
            for(int j = 0; j < dp.length; j++) {
                //dp[j][0] = 1; for square
                dp[0][j] = 1;
            }
            for(int j = 1; j < N; j++) {
                for(int k = j; k < N; k++) {
                    dp[j][k] = dp[j-1][k] + dp[j][k-1];
                }
            }
            //System.out.println(Arrays.deepToString(dp));
            System.out.println(id + " " + dp[N-1][N-1]);
        }
    }
}
