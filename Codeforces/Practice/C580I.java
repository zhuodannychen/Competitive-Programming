//Kefa and Park
//Iterative DFS

import java.util.*;
import java.io.*;
public class Main
{
    static int maxCat;
    static int[] hasCat;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("guess.in"));
        int vertices = sc.nextInt();
        maxCat = sc.nextInt();
        hasCat = new int[vertices];
        for(int i = 0; i < vertices; i++)
            hasCat[i] = sc.nextInt();

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
		//System.out.println();
		//System.out.println(Arrays.toString(adj));
        System.out.println(dfs(0,0));

    }


	public static long dfs(int vertex, int catCount)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(vertex);
		visited[vertex] = true;
		long ans = 0;

		while(!stack.isEmpty())
		{
		  vertex = stack.pop();
			//System.out.println(vertex);
			boolean flag = true;
			visited[vertex] = true;

			Iterator<Integer> itr = adj[vertex].iterator();
                            while (itr.hasNext())  
                            {
                                int child = itr.next();
				if(!visited[child]) 
				{
					flag = false;
					//stack.push(child);
					if(hasCat[child] > 0)
					{
						if(!(hasCat[vertex]+1 > maxCat))
						{
							stack.push(child);
							hasCat[child] = hasCat[vertex] + 1;
						}
					}
					else
						stack.push(child);
					visited[child] = true;	
				}
                    
					
                            }
			    if(flag)
				    ans++;
		}
		
		return ans;
	}
}
