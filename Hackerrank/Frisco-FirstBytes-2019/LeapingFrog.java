import java.io.*;
import java.util.*;

public class LeapingFrog {
    public static long n;
    public static long m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            m = sc.nextLong(); n = sc.nextLong(); long f1 = sc.nextLong(); long f2 = sc.nextLong(); long f3 = sc.nextLong();

            // l is lcm
            long l12 = LCM(f1, f2);
            long l13 = LCM(f1, f3);
            long l23 = LCM(f2, f3);
            long l123 = LCM(l23, f1);
            System.out.println(ct(f1) + ct(f2) + ct(f3) - ct(l12) - ct(l13) - ct(l23) + ct(l123));
        }
    }
    public static long GCD(long a, long b){
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }
    public static long LCM(long a, long b){
        return a * b / GCD(a,b);
    }
    public static long ct(long x){
        return (n/x) - (m-1)/x;
    }
    
}
