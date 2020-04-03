//kefa and park
//Recursion DFS

import java.util.*;

public class C580
{
    static int maxCat;
    static boolean[] hasCat;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        maxCat = sc.nextInt();
        hasCat = new boolean[vertices];
        for(int i = 0; i < vertices; i++)
            hasCat[i] = sc.nextInt() == 1;

        adj = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<Integer>();
        for(int i = 0; i < vertices - 1; i++)
        {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        visited = new boolean[vertices];
        visited[0] = true;
        System.out.println(dfs(0,0));

    }

    public static long dfs(int vertex, int catCount)
    {
        if(hasCat[vertex])
            catCount++;
        else
            catCount = 0;

        if(catCount > maxCat)
            return 0;
        long ans = 0;
        boolean ok = true;
        for(int child : adj[vertex])
        {
            if(!visited[child])
            {
                ok = false;
                visited[child] = true;
                ans += dfs(child, catCount);
            }

        }
        if(ok)
            ans++;
        return ans;
    }
}
