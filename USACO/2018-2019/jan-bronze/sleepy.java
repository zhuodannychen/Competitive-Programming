import java.util.*;
import java.io.*;

public class sleepy
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("sleepy.in"));
        int n = sc.nextInt();
        int c = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
        {
            int in = sc.nextInt();
            arr.add(in);
        }
        boolean r = isSorted(arr);
        while(!r)
        {
            c++;
            arr.remove(0);
            r = isSorted(arr);
        }
        PrintWriter pw = new PrintWriter(new File("sleepy.out"));
        pw.println(c);
        pw.close();
        System.out.println(c);
    }

    public static boolean isSorted(ArrayList<Integer> list)
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }
        return sorted;
    }
}