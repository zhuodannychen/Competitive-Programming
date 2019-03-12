import java.util.*;
import java.io.*;

public class prob02
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        if(h*s >= m)
            System.out.println(h+" "+m+" "+s+". I will make it!");
        else
            System.out.println(h+" "+m+" "+s+". I will be late!");
    }
}
