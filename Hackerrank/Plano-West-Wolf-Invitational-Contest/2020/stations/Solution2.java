import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int G = scanner.nextInt();
        int DANNY = 0, DIMMY = 0;
        for (int abc = 0; abc < G; ++abc) {
            int N = scanner.nextInt(), X = scanner.nextInt();
            boolean win = true;
            if (X % 3 != 0) {
                win = N % 3 != 0;
            } else {
                int setPos = N % (X + 1);
                win = ! (setPos % 3 == 0 && setPos != X);
            }
            if (win)
                ++DANNY;
            else ++DIMMY;
        }
        System.out.println(DANNY + ":" + DIMMY);
    }
}
