import java.util.*;
import java.io.*;

/**
 * @author Eric K. Zhang
 */
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] evts = new int[2 * M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            evts[2 * i] = 2 * s;
            evts[2 * i + 1] = 2 * e + 1;
        }

        Arrays.sort(evts);

        int x = 0, m = 0;
        for (int e : evts) {
            if (e % 2 == 0) ++x;
            else --x;
            m = Math.max(m, x);
        }

        out.println(m > 2 ? "NO" : "YES");
        out.flush();
    }
}
