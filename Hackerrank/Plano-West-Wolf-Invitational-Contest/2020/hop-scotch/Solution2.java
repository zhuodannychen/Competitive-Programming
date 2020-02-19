import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt() - 1, now = M;
        int[] vals = new int[N];
        boolean[] visited = new boolean[N];
        visited[M] = true;
        for (int i = 0; i < N; ++i)
            vals[i] = scanner.nextInt();
        while (true) {
            now += vals[now];
            now %= N;
            if (now == M) {
                System.out.println("YES");
                return;
            }
            if (visited[now]) {
                System.out.println("NO");
                return;
            }
            visited[now] = true;
        }
    }
}
