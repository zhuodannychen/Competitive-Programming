import java.util.*;
import java.io.*;

public class cowtip {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("cowtip.in"));
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            String[] str_arr = str.split("");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str_arr[j]);
            }
        }
        int steps = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(arr[i][j] == 1) {
                    steps++;
                    for(int ii = 0; ii <= i; ii++) {
                        for(int jj = 0; jj <= j; jj++) {
                            if(arr[ii][jj] == 1)
                                arr[ii][jj] = 0;
                            else
                                arr[ii][jj] = 1;
                        }
                    }
                }
            }
        }
        System.out.println(steps);
        PrintWriter pw = new PrintWriter(new File("cowtip.out"));
        pw.println(steps);
        pw.close();
    }
}
