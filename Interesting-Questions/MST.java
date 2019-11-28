// I think it works

import java.util.*;

public class MST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n_vertices = sc.nextInt();
        int n_edges = sc.nextInt();
        ArrayList<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < n_edges; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            int[] arr = {u, v, w};
            edgeList.add(arr);
        }
        Collections.sort(edgeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] > o2[2])
                    return 1;
                else
                    return -1;
            }
        });

        // begin mst
        int min_cost = 0;
        UnionFind UF = new UnionFind(n_vertices);

        for (int i = 0; i < edgeList.size(); i++) {
            int first = edgeList.get(i)[0];
            int second = edgeList.get(i)[1];
            int weight = edgeList.get(i)[2];
            if (!UF.isSameSet(first, second)) {
                min_cost += weight;
                UF.unionSet(first, second);
            }
        }
        System.out.println(min_cost);
    }
}

class UnionFind {
    private int[] p;
    private int[] rank;

    public UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = 0;
            rank[i] = 0;
        }
        for (int i = 0; i < N; i++)
            p[i] = i;
    }

    public int findSet(int i) {
        return (p[i] == i) ? i : (p[i] = findSet(p[i]));
    }

    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }
    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if (rank[x] == rank[y]) rank[y]++;
            }
        }
    }
}
