import java.util.*;

public class prob13
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String one = sc.next();
        String two = sc.next();
        String three = sc.next();
        String four = sc.next();
        if(one.equals("X"))
            System.out.printf("%.1f", Double.valueOf(two) * Double.valueOf(three) / Double.valueOf(four));
        else if(two.equals("X"))
            System.out.printf("%.1f", Double.valueOf(one) * Double.valueOf(four) / Double.valueOf(three));
        else if(three.equals("X"))
            System.out.printf("%.1f", Double.valueOf(one) * Double.valueOf(four) / Double.valueOf(two));
        else if(four.equals("X"))
            System.out.printf("%.1f", Double.valueOf(two) * Double.valueOf(three) / Double.valueOf(one));
    }
}
