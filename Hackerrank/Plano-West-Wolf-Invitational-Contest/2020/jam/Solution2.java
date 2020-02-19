import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt(), W = scanner.nextInt(), h = scanner.nextInt(), w = scanner.nextInt();
        int[] hCuts = new int[h + 1], wCuts = new int[w + 1];
        int prev = hCuts[0] = scanner.nextInt();
        
        for (int i = 1; i < h; ++i)
            hCuts[i] = -prev + (prev = scanner.nextInt());
        hCuts[h] = H - prev;
        
        prev = wCuts[0] = scanner.nextInt();
        for (int i = 1; i < w; ++i)
            wCuts[i] = -prev + (prev = scanner.nextInt());
        wCuts[w] = W - prev;
        
        //System.out.println(Arrays.toString(wCuts));
        //System.out.println(Arrays.toString(hCuts));
        
        int sum = 0;
        for (int i = 0; i < w + 1; ++i)
            for (int j = i % 2 == 0 ? 0 : 1; j < h + 1; j += 2)
                sum += hCuts[j] * wCuts[i];
        
        System.out.println(sum);
    }
}
