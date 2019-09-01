import java.util.*;
import java.io.*;

public class cowdance {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("cowdance.in"));
        int n = sc.nextInt();
        int maxTime = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = 1;
        int max = n;
        while(min != max) {
            int mid = (min + max) / 2;
            if(isValid(arr, mid, maxTime)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        PrintWriter pw = new PrintWriter(new File("cowdance.out"));
        pw.println(min);
        pw.close();
        System.out.println(min);
    }

    public static boolean isValid(int[] arr, int k, int maxTime) {
        int lastTime = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            if(q.size() == k) {
                lastTime = q.poll();
            }
            if(arr[i] + lastTime > maxTime) {
                return false;
            }
            q.add(lastTime + arr[i]);
        }
        return true;
    }
}
