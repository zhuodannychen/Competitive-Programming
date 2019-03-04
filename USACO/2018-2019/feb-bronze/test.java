import java.util.*;
import java.io.*;

class test 
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new File("revegetate.out"));
		Scanner sc = new Scanner(new File("revegetate.in"));
		int[] A = new int[151];
		int[] B = new int[151];
		int[] G = new int[101];
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(b > a)
			{
				A[i] = a;
				B[i] = b;
			}
			else
			{
				A[i] = b;
				B[i] = a;
			}
		}
		//System.out.println(Arrays.toString(A));
		//System.out.println(Arrays.toString(B));

		for(int i = 1; i <= n; i++)
		{
			int g;
			for(g = 1; g <= 4; g++)
			{
				//System.out.println(g);
				boolean ok = true;
				for(int j = 0; j < m; j++)
				{
					if(B[j] == i && G[A[j]] == g) ok = false;
				}
				if(ok) break;
			}
			G[i] = g;
			System.out.print(g);
			pw.print(g);
		}
		pw.close();
	}
}
