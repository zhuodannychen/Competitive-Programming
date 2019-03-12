import java.util.*;

public class prob04
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++)
        {
            double tax_rate = sc.nextDouble() * .01;
            double total = sc.nextDouble();
            double pretax = total / (1.0 + tax_rate);
            double tax_amount = pretax * tax_rate;
            System.out.printf("On your $%.2f purchase, the tax amount was $%.2f\n", total, tax_amount);
        }
    }
}
