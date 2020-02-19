import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
        int[] incr = new int[N + 2];
        for (int i = 0; i < M; ++i) {
            String[] in2 = reader.readLine().split(" ");
            int X = Integer.parseInt(in2[0]), Y = Integer.parseInt(in2[1]);
            incr[X]++;
            incr[Y + 1]--;
        }
        int counter = 0;
        for (int i = 1; i < N + 1; ++i)
            if ((counter += incr[i]) > 2) {
                System.out.println("NO");
                return;
            }
        System.out.println("YES");
    }
}
