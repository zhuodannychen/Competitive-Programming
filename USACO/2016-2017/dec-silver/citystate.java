import java.util.*;
import java.io.*;

public class citystate {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("citystate.in"));
        Map<String, Integer> map = new HashMap<>();
        int cases = sc.nextInt();
        PrintWriter pw = new PrintWriter(new File("citystate.out"));
        for(int i = 0; i < cases; i++) {
            String city = sc.next(); String state = sc.next();
            if(!city.substring(0,2).equals(state)) {
                String fourLetter = city.substring(0, 2) + state;
                if(!map.containsKey(fourLetter)) {
                    map.put(fourLetter, 0);
                }
                map.put(fourLetter, map.get(fourLetter) + 1);

            }
        }

        int result = 0;
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            String partner = key.substring(2,4) + key.substring(0,2);
            if(map.containsKey(partner)) {
                result += map.get(key) * map.get(partner);
            }
        }
        System.out.println(result / 2);
        pw.println(result / 2);
        pw.close();


    }
}
