import java.util.*;
import java.io.*;

public class shell
{
    public static void main(String[] args) throws IOException
    {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int[] arr = {1,2,3};
        Scanner sc = new Scanner(new File("shell.in"));
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = sc.nextInt();

            if((a == 1 && b == 2) || (a == 2 && b == 1))
            {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }

            if((a == 2 && b == 3) || (a == 3 && b == 2))
            {
                int temp = arr[1];
                arr[1] = arr[2];
                arr[2] = temp;
            }

            if((a == 1 && b == 3) || (a == 3 && b == 1))
            {
                int temp = arr[2];
                arr[2] = arr[0];
                arr[0] = temp;
            }

            if(arr[g-1] == 1)
                ones++;
            else if(arr[g-1] == 2)
                twos++;
            else
                threes++;
        }
        //System.out.println(Arrays.toString(arr));
        int result = Math.max(Math.max(ones, twos), threes);
        PrintWriter pw = new PrintWriter(new File("shell.out"));
        pw.println(result);
        pw.close();
        System.out.println(result);

    }
}