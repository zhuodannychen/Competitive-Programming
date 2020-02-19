import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while (scan.hasNext())
            if (scan.next().equals("not"))
                ++count;
        System.out.println(count % 2 == 0 ? "LOVE" : "SAD");
    }
}
