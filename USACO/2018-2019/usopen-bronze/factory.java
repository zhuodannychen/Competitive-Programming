// based off usaco website solution

import java.util.*;
import java.io.*;

class factory{
    public static void main(String[] args) throws IOException{
        int[] out = new int[101];
        Scanner sc = new Scanner(new File("factory.in"));
        int n = sc.nextInt();
        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt(); int b = sc.nextInt();
            out[a]++;
        }
        System.out.println(Arrays.toString(out));
        int ans = -1;
        for(int i = 1; i <= n; i++){
            if(out[i] == 0 && ans != -1){
                ans = -1;
                break;
            }
            else if(out[i] == 0){
                ans = i;
            }
        }
        System.out.println(ans);
        PrintWriter pw = new PrintWriter(new File("factory.out"));
        pw.println(ans);
        pw.close();
    }
}
