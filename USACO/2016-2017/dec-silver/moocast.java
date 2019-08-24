//using Adjacency List and BFS

import java.util.*;
import java.io.*;

public class moocast {
    public static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("moocast.in"));
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] p = new int[n];
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            p[i] = sc.nextInt();
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) <= p[i] * p[i]) {
                    adjList[i].add(j);
                }
            }
        }
        /*
        for(int i = 0; i < n; i++) {
            if(adjList[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < adjList[i].size(); j++) {
                    System.out.print(adjList[i].get(j) + " ");
                }
                System.out.println();
            }
        }
        */
        int max = 0;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[j] = false;
            }
            q.add(i);
            visited[i] = true;
            int total = 0;
            while(!q.isEmpty()) {
                total++;
                int a = q.poll();
                for(int j : adjList[a]) {
                    if(!visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            max = Math.max(max, total);
        }
        System.out.println(max);
        PrintWriter pw = new PrintWriter(new File("moocast.out"));
        pw.println(max);
        pw.close();
    }
}


//Using Adjacency Matrix and DFS
/*
import java.util.*;
import java.io.*;

public class moocast {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("moocast.in"));
        int cows = sc.nextInt();
        int[] x = new int[cows];
        int[] y = new int[cows];
        int[] p = new int[cows];
        for(int i = 0; i < cows; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        boolean[][] adjMatrix = new boolean[cows][cows];
        for(int i = 0; i < cows; i++) {
            for(int j = 0; j < cows; j++) {
                if((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) <= p[i] * p[i])
                    adjMatrix[i][j] = true;
            }
        }

        int max = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < cows; i++) {
            boolean[] visited = new boolean[cows];
            int count = 0;
            s.add(i);
            visited[i] = true;
            while(!s.isEmpty()) {
                count++;
                int a = s.pop();
                for(int j = 0; j < cows; j++) {
                    if(adjMatrix[a][j] && !visited[j]) {
                        visited[j] = true;
                        s.add(j);
                    }
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
        PrintWriter pw = new PrintWriter("moocast.out");
        pw.println(max);
        pw.close();
    }
}
*/
