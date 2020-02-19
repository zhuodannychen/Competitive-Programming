import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double x = scanner.nextDouble(), y = scanner.nextDouble(), x2 = scanner.nextDouble(), y2 = scanner.nextDouble();
        double L = Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
        double theta = Math.atan2(y2 - y, x2 - x);
        double dtheta = 2 * Math.PI / N;
        for (int i = 0; i < N; ++i) {
            System.out.println(x + " " + y);
            x += L * Math.cos(theta);
            y += L * Math.sin(theta);
            theta += dtheta;
        }
    }
}
