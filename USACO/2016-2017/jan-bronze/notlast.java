//not very efficient : )

import java.util.*;
import java.io.*;

public class notlast {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("notlast.in"));
        int n = sc.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String s = sc.next(); int a = sc.nextInt();
            if(!map.containsKey(s))
                map.put(s, a);
            else
                map.put(s, map.get(s) + a);
        }
        List<Integer> sortByInt = new ArrayList<>(map.values());
        Collections.sort(sortByInt);
        
        boolean tie = true;
        int index = 0;
        for(int i = 0; i < n - 1; i++) {
            if(sortByInt.get(i) != sortByInt.get(i + 1)) {
                index = i + 1;
                tie = false;
                break;
            }
        }
        PrintWriter pw = new PrintWriter(new File("notlast.out"));
        if(n < 2) {
            for(String s : map.keySet()) {
                System.out.println(s);
                pw.println(s);
            }
        }
        else if(tie == true) {
            System.out.println("Tie");
            pw.println("Tie");
        } else {
            for(String s : map.keySet()) {

                if(map.get(s) == sortByInt.get(index)) {
                    System.out.println(s);
                    pw.println(s);
                }
            }
        }
        pw.close();
    }
}
