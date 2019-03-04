import java.util.*;
import java.io.*;

class Traffic
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new File("traffic.in"));
		int n = sc.nextInt();
		String[] T = new String[101];
		int[] A = new int[101];
		int[] B = new int[101];

		for(int i = 0; i < n; i++)
		{
			T[i] = sc.next();
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(B));

		int min = -9999999;
		int max = 9999999;
		for(int i = n-1; i >= 0; i--)
		{
			if(T[i].equals("none"))
			{
				min = Math.max(min, A[i]);
				max = Math.min(max, B[i]);
			}
			else if(T[i].equals("off"))
			{
				min += A[i];
				max += B[i];
			}
			else
			{
				max -= A[i];
				min -= B[i];
				min = Math.max(0, min);
			}
		}

		int min1 = -9999999;
		int max1 = 9999999;
		for(int i = 0; i < n; i++)
		{
			if(T[i].equals("none"))
			{
				min1 = Math.max(min1, A[i]);
				max1 = Math.min(max1, B[i]);
			}
			else if(T[i].equals("on"))
			{
				min1 += A[i];
				max1 += B[i];
			}
			else
			{
				max1 -= A[i];
				min1 -= B[i];
				min1 = Math.max(0, min1);
			}
		}
		PrintWriter pw = new PrintWriter(new File("traffic.out"));
		pw.println(min + " " + max);
		pw.println(min1 + " " + max1);
		pw.close();
	}
}
