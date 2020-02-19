import java.util.*;
import java.io.*;

/**
 * @author Eric K. Zhang
 */
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.parseInt(br.readLine());
        int start = Integer.parseInt(br.readLine(), 2);
        int dest = Integer.parseInt(br.readLine(), 2);

        int[] dist = new int[1 << N];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int n = q.poll();
            int idx = 0;
            while (idx < N) {
                if ((n & (1 << idx)) == 0) {
                    int v = n | (1 << idx);
                    if (dist[v] == -1) {
                        dist[v] = dist[n] + 1;
                        q.add(v);
                    }
                    idx++;
                }
                else {
                    int k = idx;
                    while ((n & (1 << idx)) > 0) {
                        ++idx;
                        int v = n - (1 << idx) + (1 << k);
                        if (k > 0)
                            v += (1 << (k - 1));
                        if (dist[v] == -1) {
                            dist[v] = dist[n] + 1;
                            q.add(v);
                        }
                    }
                }
            }
        }

        out.println(dist[dest]);
        out.flush();
    }
}
