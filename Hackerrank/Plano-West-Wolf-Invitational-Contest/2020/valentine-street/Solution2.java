import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), K = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; ++i)
            arr.add(new Integer(scanner.nextInt() - 1));
        arr.sort(Integer::compareTo);
        int total = 0;
        int index = arr.size() % K - 1;
        if (index == -1)
            index += K;
        for (; index < arr.size(); index += K)
            total += 2 * arr.get(index);
        System.out.println(total);
    }
}