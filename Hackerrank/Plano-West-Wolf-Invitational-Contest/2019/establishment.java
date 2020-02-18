import java.io.*;
import java.util.*;
import java.math.*;

public class establishment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int c = sc.nextInt();
            BigInteger b = new BigInteger(Integer.toString(c));
            System.out.println(b.nextProbablePrime());
            
        }
    }
}
