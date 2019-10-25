import java.io.*;
import java.util.*;

public class StickyFingers {

    public static final int MAXN = 100;
    public static final int MAXK = 1000;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new File("maxcross.in"));
        int n = sc.nextInt();
        int money = Integer.parseInt(sc.next().replaceAll("[.]", ""));
        int fingers = sc.nextInt();

        int[] value = new int[MAXN+1];
        int[] cost = new int[MAXK + 1];
        int[][][] dp = new int[MAXN+1][MAXK+1][MAXN+1]; //value, cost, fingers

        for(int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(sc.next().replaceAll("[.]", ""));
            value[i] = sc.nextInt();
        }

        for(int i = 0; i <= money; i++){
            for(int j = 0; j <= fingers; j++){
                dp[0][i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= money; j++){
                for(int k = 0; k <= fingers; k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(k > 0)
                        dp[i][j][k] = Math.max(dp[i][j][k], value[i] + dp[i-1][j][k-1]);
                    if(cost[i] <= j)
                        dp[i][j][k] = Math.max(dp[i][j][k], value[i] + dp[i-1][j-cost[i]][k]);

                }
            }
        }
        System.out.println(dp[n][money][fingers]);
    }
}
