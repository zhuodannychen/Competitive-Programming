import java.io.*;
import java.util.*;
import java.math.*;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int abc = 0; abc < N; ++abc) {
            int M = scanner.nextInt(), S = scanner.nextInt();
            BigInteger[] allTrees = new BigInteger[M];
            BigInteger[] symTrees = new BigInteger[M];
            int[] branches = new int[S];
            
            for (int i = 0; i < S; ++i)
                branches[i] = scanner.nextInt();
            
            allTrees[0] = BigInteger.valueOf(S);
            symTrees[0] = BigInteger.valueOf(S);
            
            for (int i = 1; i < M; ++i) {
                allTrees[i] = BigInteger.ZERO;
                symTrees[i] = BigInteger.ZERO;
                for (int dist : branches) {
                    allTrees[i] = allTrees[i].add(allTrees[i - 1].pow(dist));
                    if (dist % 2 == 0)
                        symTrees[i] = symTrees[i].add(allTrees[i - 1].pow(dist / 2));
                    else symTrees[i] = symTrees[i].add(allTrees[i - 1].pow(dist / 2).multiply(symTrees[i - 1]));
                }
            }
            
            System.out.println(allTrees[M-1].subtract(symTrees[M-1]).divide(BigInteger.valueOf(2)).add(symTrees[M-1]).mod(BigInteger.valueOf((long) Math.pow(10, 9) + 7)));
            
        }
    }
    
}
