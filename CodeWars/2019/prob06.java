import java.util.*;
public class prob06
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int couples = sc.nextInt();
        int result = 0;
        int count = couples-1;
        for(int i = 0; i < couples; i++)
        {
            result += 4*count;
            count--;
        }
        System.out.println(result);
    }
}
