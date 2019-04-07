https://www.hackerrank.com/contests/spring-2019-battle-of-the-brains

import java.io.*;
import java.util.*;

public class Camp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            int N = sc.nextInt(); int M = sc.nextInt();
            String[][] arr = new String[N][M];
            for(int j = 0; j < N; j++){
                String str = sc.next();
                for(int k = 0; k < M; k++)
                    arr[j][k] = str.substring(k, k + 1);
            }
            boolean valid = true;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(arr[j][k].equals("t")){
                        if(j - 1 >= 0){
                            if(k - 1 >= 0){
                                if(arr[j-1][k-1].equals("t"))
                                    valid = false;
                            }
                            if(arr[j-1][k].equals("t"))
                                valid = false;
                            if(k + 1 < M){
                                if(arr[j-1][k+1].equals("t"))
                                    valid = false;
                            }
                        }
                        if(j + 1 < N){
                            if(k - 1 >= 0){
                                if(arr[j+1][k-1].equals("t"))
                                    valid = false;
                            }
                            if(arr[j+1][k].equals("t"))
                                valid = false;
                            if(k + 1 < M){
                                if(arr[j+1][k+1].equals("t"))
                                    valid = false;
                            }
                        }
                        if(k - 1 >= 0){
                            if(arr[j][k-1].equals("t"))
                                valid = false;
                        }
                        if(k + 1 < M){
                            if(arr[j][k+1].equals("t"))
                                valid = false;
                        }
                    }
                }
            }
            //System.out.println(Arrays.deepToString(arr));
            System.out.println(valid ? "Valid" : "Invalid");
        }
    }
}
