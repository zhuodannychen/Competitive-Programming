import java.util.*;
import java.io.*;

/**
 * @author Eric K. Zhang
 */
public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] degL = new int[H];
        int[] degR = new int[W];
        int s = H + W, t = H + W + 1;
        List<MaxFlowDinic.Edge>[] graph = MaxFlowDinic.createGraph(H + W + 2);
        char[][] ans = new char[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                ans[i][j] = line.charAt(j);
                if (line.charAt(j) == '*') {
                    ++degL[i]; ++degR[j];
                    MaxFlowDinic.addEdge(graph, i, H + j, 1);
                }
            }
        }

        for (int i = 0; i < H; i++) {
            assert(degL[i] % 2 == 0);
            MaxFlowDinic.addEdge(graph, s, i, degL[i] / 2);
        }
        for (int i = 0; i < W; i++) {
            assert(degR[i] % 2 == 0);
            MaxFlowDinic.addEdge(graph, H + i, t, degR[i] / 2);
        }

        MaxFlowDinic.maxFlow(graph, s, t);
        for (int i = 0; i < H; i++) {
            for (MaxFlowDinic.Edge e : graph[i]) {
                if (e.t != s) {
                    int j = e.t - H;
                    ans[i][j] = (e.f > 0 ? 'X' : 'O');
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++)
                out.print(ans[i][j]);
            out.println();
        }

        out.flush();
    }
}

// Source: Andrei Navumenka
class MaxFlowDinic {

    static class Edge {
        int t, rev, cap, f;

        public Edge(int t, int rev, int cap) {
            this.t = t;
            this.rev = rev;
            this.cap = cap;
        }
    }

    public static List<Edge>[] createGraph(int nodes) {
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        return graph;
    }

    public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(t, graph[t].size(), cap));
        graph[t].add(new Edge(s, graph[s].size() - 1, 0));
    }

    static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
        Arrays.fill(dist, -1);
        dist[src] = 0;
        int[] Q = new int[graph.length];
        int sizeQ = 0;
        Q[sizeQ++] = src;
        for (int i = 0; i < sizeQ; i++) {
            int u = Q[i];
            for (Edge e : graph[u]) {
                if (dist[e.t] < 0 && e.f < e.cap) {
                    dist[e.t] = dist[u] + 1;
                    Q[sizeQ++] = e.t;
                }
            }
        }
        return dist[dest] >= 0;
    }

    static int dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest, int u, int f) {
        if (u == dest)
            return f;
        for (; ptr[u] < graph[u].size(); ++ptr[u]) {
            Edge e = graph[u].get(ptr[u]);
            if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
                int df = dinicDfs(graph, ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
                if (df > 0) {
                    e.f += df;
                    graph[e.t].get(e.rev).f -= df;
                    return df;
                }
            }
        }
        return 0;
    }

    public static int maxFlow(List<Edge>[] graph, int src, int dest) {
        int flow = 0;
        int[] dist = new int[graph.length];
        while (dinicBfs(graph, src, dest, dist)) {
            int[] ptr = new int[graph.length];
            while (true) {
                int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
                if (df == 0)
                    break;
                flow += df;
            }
        }
        return flow;
    }
}
