import java.io.*;
import java.util.*;

public class Prob06 {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int num = reader.nextInt();
        for (int i = 0; i<num; i++){
            int alt = reader.nextInt();
            double ans = 40075 + (double) (2 * Math.PI * alt);
            System.out.printf("%.1f", ans);
            System.out.println();

        }
    }
}
