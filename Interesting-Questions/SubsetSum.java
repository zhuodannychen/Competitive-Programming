//Finds whether a given list of numbers can form a specific sum
//recursive solution. Exponential time

import java.util.*;
import java.io.*;

class SubsetSum
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new File("guess.in"));
		int cases = sc.nextInt();
		for(int i = 0; i < cases; i++)
		{
			int n = sc.nextInt();
			int goal = sc.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++)
				arr[j] = sc.nextInt();
			if(result(arr, n, goal))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	static boolean result(int[] arr, int n, int goal)
	{
		if(goal == 0)
			return true;
		if(n == 0 && goal != 0)
			return false;
		if(arr[n-1] > goal)
			return result(arr, n-1, goal);
		return result(arr, n-1, goal) || result(arr, n-1, goal-arr[n-1]);
	}
}
