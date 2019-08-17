import java.util.*;
import java.io.*;

public class haybales {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("haybales.in"));
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        PrintWriter pw = new PrintWriter(new File("haybales.out"));
        for(int i = 0; i < Q; i++) {
            int a = sc.nextInt(); int b = sc.nextInt();
            System.out.println(binary_search(arr, b) - binary_search(arr, a - 1));
            pw.println(binary_search(arr, b) - binary_search(arr, a - 1));
        }
        pw.close();
    }

    public static int binary_search(int[] arr, int limit) {
        if(limit < arr[0])
            return 0;
        int min = 0;
        int max = arr.length - 1;
        while(min != max) {
            int mid = (min + max + 1) / 2;
            if(arr[mid] <= limit) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min + 1;
    }
}
