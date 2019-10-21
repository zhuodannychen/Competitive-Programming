import java.io.*;
import java.util.*;

public class Chocount {

    public static int MOD = (int)1e9 + 7;
    public static long[][] arr = new long[300][300];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        arr[0][0] = 1;
        for(int i = 1; i < 300; i++) {
            arr[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1]) % MOD;
            }
        }
        if(k-m-n < 0)
            System.out.println(0);
        else
            System.out.println(arr[k-m][n-1]);
    }
}
