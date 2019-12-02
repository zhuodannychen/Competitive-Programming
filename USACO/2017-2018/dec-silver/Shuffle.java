import java.util.*;
import java.io.*;

public class Shuffle {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("shuffle.in"));
        PrintWriter pw = new PrintWriter(new File("shuffle.out"));
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] ori = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() - 1;
            ori[arr[i]]++;
        }

        int ret = n;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ori[i] == 0) {
                q.add(i);
                ret--;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.removeFirst();
            if (--ori[arr[curr]] == 0) {
                q.add(arr[curr]);
                ret--;
            }
        }
        System.out.println(ret);
        pw.println(ret);
        pw.close();

    }
}
