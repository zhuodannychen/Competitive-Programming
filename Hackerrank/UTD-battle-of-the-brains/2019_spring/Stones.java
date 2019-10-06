import java.io.*;
import java.util.*;

public class Stones {
    public static int[] count = new int[(int) 1e6 + 1];
    public static int[] arr = new int[50];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt(); int K = sc.nextInt();
            Arrays.fill(count, 0);
            count[0] = 1;
            for(int j = 0; j < K; j++){
                arr[j] = sc.nextInt();
            }
            
            for(int j = 1; j <= N; j++){
                for(int k = 0; k < K; k++){
                    if(arr[k] <= j){
                        count[j] = (count[j] + count[j-arr[k]]) % ((int)(1e9) + 7);
                    }
                }
            }
            System.out.println(count[N]);
        }
        
    }
}
