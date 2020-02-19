import java.util.*;
import java.io.*;

/**
 * @author Eric K. Zhang
 */
public class Solution1 {

    static final int MAXLG = 18;
    static List<Integer>[] adj;
    static int[] depth, in, ot;
    static int t;
    static int[][] L; // take the L :)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        depth = new int[N];
        in = new int[N];
        ot = new int[N];
        L = new int[MAXLG][N];
        adj = new List[N];
        for (int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, 0);

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            int u = lca(a, b);
            int v = lca(c, d);
            boolean ans = isect(u, a, v, c) || isect(u, a, v, d) || isect(u, b, v, c) || isect(u, b, v, d);
            out.println(ans ? "YES" : "NO");
        }

        out.flush();
    }

    static void dfs(int n, int p) {
        depth[n] = depth[p] + 1;
        in[n] = t++;
        L[0][n] = p;
        for (int i = 0; i < MAXLG - 1; i++)
            L[i + 1][n] = L[i][L[i][n]];
        for (int v : adj[n]) {
            if (v != p)
                dfs(v, n);
        }
        ot[n] = t;
    }

    static int lca(int u, int v) {
        for (int i = MAXLG - 1; i >= 0; i--) {
            if (depth[u] - (1<<i) >= depth[v]) u = L[i][u];
            if (depth[v] - (1<<i) >= depth[u]) v = L[i][v];
        }
        for (int i = MAXLG - 1; i >= 0; i--) {
            if (L[i][u] != L[i][v]) {
                u = L[i][u];
                v = L[i][v];
            }
        }
        return u == v ? u : L[0][u];
    }

    static boolean isect(int a1, int d1, int a2, int d2) {
        if (depth[a1] > depth[a2])
            return isect(a2, d2, a1, d1);
        return in[a1] <= in[a2] && in[a2] < ot[a1] && in[a2] <= in[d1] && in[d1] < ot[a2];
    }
}
