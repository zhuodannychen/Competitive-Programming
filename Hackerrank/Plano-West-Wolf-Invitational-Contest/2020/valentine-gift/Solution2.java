import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Math.min(scan.nextInt(), Math.min(scan.nextInt() / 2, scan.nextInt() / 4)));
    }
}
