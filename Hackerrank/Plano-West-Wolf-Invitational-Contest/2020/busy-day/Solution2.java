import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solve() ? "YES" : "NO");
    }
    
    static boolean solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] dense = new double[2];
        dense[0] = scanner.nextDouble();
        dense[1] = 24 - scanner.nextDouble();
        List<Double> vals = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            vals.add(scanner.nextDouble());
        vals.sort((a, b) -> (int) (10000000 * (b - a)));
        for (Double next : vals) {
            boolean ok1 = dense[0] >= next, ok2 = dense[1] >= next;
            if (!ok1 && !ok2)
                return false;
            else if (!ok1)
                dense[1] -= next;
            else if (!ok2)
                dense[0] -= next;
            else if (dense[0] < dense[1])
                dense[0] -= next;
            else dense[1] -= next;
        }
        return true;
    }
}
