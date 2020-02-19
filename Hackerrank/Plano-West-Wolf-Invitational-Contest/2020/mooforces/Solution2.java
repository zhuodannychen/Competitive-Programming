import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = reader.readLine().split(" ");
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
        List<Cow> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            in = reader.readLine().split(" ");
            list.add(new Cow(in[0], Integer.parseInt(in[1]), Integer.parseInt(in[2]), Integer.parseInt(in[3])));
        }
        list.sort(Cow::comp);
        for (int i = 0 ; i < M; ++i)
            System.out.println(list.get(i).name);
    }
    
    static class Cow {
        int score, inc, time;
        String name;
        public Cow(String name, int a, int b, int c) {
            this.name = name;
            this.score = a;
            this.inc = b;
            this.time = c;
        }
        
        static int comp(Cow c1, Cow c2) {
            if (c1.score != c2.score)
                return c2.score - c1.score;
            if (c1.inc != c2.inc)
                return c1.inc - c2.inc;
            if (c1.time != c2.time)
                return c1.time - c2.time;
            return c1.name.compareTo(c2.name);
        }
    }
}
