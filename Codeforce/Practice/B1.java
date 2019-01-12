//Spreadsheet

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		for(int i = 0; i < cases; i++)
		{
			String test = sc.next();
			if(test.matches("R[0-9]+C[0-9]+"))
			{
				//String[] nums = new String[test.length()];
				String[] nums = test.split("R|C");
				//System.out.println(Arrays.toString(nums));
				int x = Integer.parseInt(nums[2]);

				String column = "";
				while(x != 0)
				{
					if(x%26==0)
					{
						column = 'Z' + column;
						x -= 26;
					}
					else
					{
						column = (char)('A' - 1 + x%26) + column;
					}
					x/=26;
				}
				//System.out.println();
				System.out.println(column+nums[1]);
			}
			else
			{
				String letters = test.replaceAll("[0-9]", "");
				String numbers = test.replaceAll("[A-Z]", "");
				
				int base=1;
				int t=0;
				for(int j=letters.length()-1;j>=0;j--)
				{
					t+=base*(letters.charAt(j)-'A'+1);
					base*=26;
				}
				System.out.println("R" + numbers + "C" + t);
			}
		}
	}
}
