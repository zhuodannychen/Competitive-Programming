import java.io.*;
import java.util.*;

public class IntegerEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int id = sc.nextInt();
            if(id == 0)
                break;
            int D = sc.nextInt(); int A = sc.nextInt(); int B = sc.nextInt(); int E = sc.nextInt(); int F = sc.nextInt();
            int[] pair = new int[2];
            ArrayList<int[]> points = new ArrayList<>();
            int limitx = D / A;
            int limity = D / B;
            for(int i = 0; i <= limitx; i++) {
                int y = (D - i * A) / B;
                if(y * B + A * i == D)
                    points.add(new int[] {i, y});
            }
            /*
            for(int[] arr : points) {
                System.out.println(Arrays.toString(arr));
            }
            */
            if(points.isEmpty())
                System.out.println(id + " failed");
            else {
                int min = Integer.MAX_VALUE;
                int[] coord = new int[2];
                for(int[] arr : points) {
                    if(E * arr[0] + F * arr[1] < min) {
                        min = E * arr[0] + F * arr[1];
                        coord[0] = arr[0];
                        coord[1] = arr[1];
                    }
                }
                System.out.println(id + " " + coord[0] + " " + coord[1]);
            }
        }
    }
}
