import java.nio.Buffer;
import java.util.*;
import java.io.*;

class milkvisits {
    public static int[] comp = new int[100001];
    public static int num = 0;
    public static ArrayList<Integer>[] adj;
    public static char[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new File("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        cows = new char[n];
        adj = new ArrayList[n];
        cows = bf.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            u--; v--;
            adj[u].add(v); adj[v].add(u);
        }
        for (int i = 0; i < n; i++) {
            if (comp[i] == 0) {
                num++;
                dfs(i);
            }
        }
        //System.out.println(Arrays.toString(comp));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            char preference = st.nextToken().charAt(0);
            if (cows[start] == preference || comp[start] != comp[end]) {
                pw.print(1);
            } else {
                pw.print(0);
            }
        }
        pw.close();
    }

    public static void dfs(int x) {
        if (comp[x] != 0)
            return;
        comp[x] = num;
        for (int i : adj[x]) {
            if (cows[i] == cows[x])
                dfs(i);
        }
    }
}
