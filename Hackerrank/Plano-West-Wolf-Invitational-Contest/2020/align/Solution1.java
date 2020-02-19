import java.util.*;

class Solution1 {
    public static final int TOGGLE = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int max = 0;
        int start = 0;
        // 0 - >, 1 - <
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            int index = (current == '>') ? 0 : 1;
            max = Math.max(max, ++count[index]);
            while (max + TOGGLE <= i - start) {
                char s = str.charAt(start++);
                index = (s == '>') ? 0 : 1;
                --count[index];
            }
        }
        System.out.println(str.length() - start);
    }
}
