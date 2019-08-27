import java.util.*;
import java.io.*;

public class hps {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("hps.in"));
        int n = sc.nextInt();
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < n; i++) {
            int cow1 = sc.nextInt(); int cow2 = sc.nextInt();
            if(cow1 == cow2)
                continue;
            else if((cow1 == 2 && cow2 == 1) || (cow1 == 3 && cow2 == 2) || (cow1 == 1 && cow2 == 3))
                max1++;
            else if((cow1 == 3 && cow2 == 1) || (cow1 == 2 && cow2 == 3) || (cow1 == 1 && cow2 == 2))
                max2++;
        }
        System.out.println(Math.max(max1, max2));
        PrintWriter pw = new PrintWriter(new File("hps.out"));
        pw.println(Math.max(max1, max2));
        pw.close();
    }
}
