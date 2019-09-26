import java.util.*;
import java.io.*;

public class crossroad {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("crossroad.in"));
        int cows = sc.nextInt();
        int sum = 0;
        int[] sides = new int[10];
        Arrays.fill(sides, -1);
        for(int i = 0; i < cows; i++) {
            int id = sc.nextInt() - 1; int side = sc.nextInt();
            if(sides[id] != side && sides[id] != -1) {
                sum++;
            }
            sides[id] = side;
        }

        System.out.println(sum);
        PrintWriter pw = new PrintWriter(new File("crossroad.out"));
        pw.println(sum);
        pw.close();
    }
}
