import java.util.*;
import java.io.*;

public class Homework {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("homework.in"));
        PrintWriter pw = new PrintWriter(new File("homework.out"));
        int n = sc.nextInt();
        int[] arr = new int[100001];
        int[] min = new int[100001];
        int[] result = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        min[n-1] = arr[n-1];
        result[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            result[i] = result[i+1] + arr[i]; //total sum array
            min[i] = Math.min(min[i+1], arr[i]); //finds the min value
        }
        double max = Double.MIN_VALUE;
        // finds max value in result
        for (int i = 1; i < n-1; i++) {
            max = (Math.max(max, 1.0 * (result[i] - min[i]) / (n - i - 1)));
        }
        //System.out.println(max);
        for (int i = 1; i < n-1; i++) {
            if (max == (1.0 * (result[i] - min[i]) / (n - i - 1))) {
                pw.println(i);
                //System.out.print(i + " ");
            }
        }
        pw.close();

    }
}
