import java.util.*;
import java.io.*;

public class Planting {
    public static void main(String[] args) throws IOException {
        Scanner fc = new Scanner(new File("planting.in"));
        int n = fc.nextInt();
        int[] d = new int[n+1];
        for (int i = 1; i < n; i++) {
            int a = fc.nextInt();
            int b = fc.nextInt();
            ++d[a]; ++d[b];
        }

        int max = 0;
        for (int i = 1; i < n; i++)
            max = Math.max(max, d[i]);
        System.out.println(max + 1);
        PrintWriter pw = new PrintWriter(new File("planting.out"));
        pw.println(max+1);
        pw.close();
    }
}
