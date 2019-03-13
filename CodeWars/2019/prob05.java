import java.util.*;

public class prob05
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int layers = sc.nextInt();
        int result = 0;
        for(int i = layers; i >= 1; i--)
        {
            result += Math.pow(i, 2);
        }
        System.out.println(result);
    }
}
