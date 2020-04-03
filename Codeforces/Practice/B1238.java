import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2
3 2
1 3 5
4 1
5 2 3 5

 */
//Scanner gave Time Limit
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(bf.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st;
        for(int i = 0; i < queries; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            int monsters = Integer.parseInt(st.nextToken());
            int bounce = Integer.parseInt(st.nextToken());
            set.clear();
            st = new StringTokenizer(bf.readLine().trim());
            for(int j = 0; j < monsters; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            //System.out.println(set);
            int count = 0;
            while(!set.isEmpty()) {
                if(set.pollLast() <= bounce * count)
                    break;
                count++;
            }
            System.out.println(count);
        }
    }
}
