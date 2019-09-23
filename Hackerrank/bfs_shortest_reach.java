import java.io.*;
import java.util.*;

public class Solution {
    public static ArrayList<Integer>[] adjList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for(int i = 0; i < queries; i++) {
            int n = sc.nextInt(); int m = sc.nextInt();
            adjList = new ArrayList[n];
            for(int ii = 0; ii < n; ii++) {
                adjList[ii] = new ArrayList<Integer>();
            }
            for(int j = 0; j < m; j++) {
                int u = sc.nextInt(); int v = sc.nextInt();
                adjList[u - 1].add(v - 1);
                adjList[v - 1].add(u - 1);
                //adj list
            }
            int s = sc.nextInt() - 1;

            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            int[] dist = new int[n];
            for(int j = 0; j < n; j++) {
                dist[j] = -1;
            }
            dist[s] = 0;
            q.add(s);
            visited[s] = true;
            while(!q.isEmpty()) {
                int current = q.poll();
                for(int node : adjList[current]) {
                    if(!visited[node]) {
                        q.add(node);
                        visited[node] = true;
                        dist[node] = dist[current] + 6;
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                if(dist[j] != 0)
                    System.out.print(dist[j] + " ");
            }
            System.out.println();
        }
    }
}
