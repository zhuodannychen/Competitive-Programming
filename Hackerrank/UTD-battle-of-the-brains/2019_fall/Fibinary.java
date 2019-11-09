// I think it works?

import java.util.*;
import java.io.*;

public class Fibinary{
    public static int[][] dp = new int[31][(int)1e6+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(Arrays.deepToString(dp));
        int t = sc.nextInt();
        int[] fib = new int[31];
        fib[0] = fib[1] = 1;
        for(int i = 2; i < 31; i++)
            fib[i] = fib[i-1] + fib[i-2];

        dp[0][0] = 1;
        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < (int)1e6+1; j++) {
                if(dp[i][j] != 0) {
                    if(j + fib[i] < (int)1e6+1)
                        dp[i+1][j+fib[i]] += dp[i][j];
                    dp[i+1][j] += dp[i][j];
                }
            }
        }
        while(t-- > 0) {
            int num = sc.nextInt();
            System.out.println(dp[30][num]);
        }
    }
}
