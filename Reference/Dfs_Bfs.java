import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("Test.txt"));
        int vertices = sc.nextInt();

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
        //visited[0] = true;
        System.out.println();
        System.out.println(Arrays.toString(adj));
        dfs(0, visited);
		//bfs(0, visited);

    }


    public static void dfs(int vertex, boolean[] visited)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(vertex);
        //long ans = 0;

        while(!stack.isEmpty())
        {
            vertex = stack.peek();
            stack.pop();
            System.out.println(vertex+1);
            visited[vertex] = true;
            Iterator<Integer> itr = adj[vertex].iterator();

            while (itr.hasNext())
            {
                int child = itr.next();
                if(!visited[child])
				{
					visited[child] = true;
					stack.push(child);
				}
            }

        }
    }


	public static void bfs(int vertex, boolean[] visited)
	{
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		while(queue.size() != 0)
		{
			vertex = queue.poll();
			System.out.println(vertex+1);
			visited[vertex] = true;
			Iterator<Integer> i = adj[vertex].iterator();
			while(i.hasNext())
			{
				int child = i.next();
				if(!visited[child])
				{
					visited[child] = true;
					queue.add(child);
				}
			}
		}
	}
}
