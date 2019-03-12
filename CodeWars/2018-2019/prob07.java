import java.math.BigInteger;
import java.util.*;

public class prob07
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m == 0 && n == 0)
                break;
            else if(m == 0)
            {
                if(n % 2 == 0)
                    System.out.println(n+2);
                else
                    System.out.println(n+1);
            }
            else if(m == 1)
            {
                BigInteger b = new BigInteger(String.valueOf(n));
                b = b.nextProbablePrime();
                System.out.println(b);
            }
            else if(m == 2)
            {
                int i = 1;
                while(Math.pow(i, 2) < n)
                {
                    i++;
                }
                System.out.println((int)(Math.pow(i, 2)));
            }
            else if(m == 3)
            {
                int i = 1;
                while(Math.pow(i, 3) < n)
                {
                    i++;
                }
                System.out.println((int)Math.pow(i, 3));
            }
        }
    }
}
