import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (sc.hasNext()) {
            String num = sc.next();
            if (isNumeric(num)) {
                arr.add(Integer.parseInt(num));
            }
            else {
                continue;
            }
        }
        //System.out.println(arr);
        int ans = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (count == 0) {
                ans += arr.get(i);
            }
            if (count == 1) {
                ans -= arr.get(i);
            }
            if (count == 2) {
                ans *= arr.get(i);
            }
            if (count == 3) {
                if (arr.get(i) == 0) {
                    continue;
                }
                ans /= arr.get(i);
            }
            count++;
            if (count > 3)
                count = 0;
        }
        System.out.println(ans);
    }
    public static boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
