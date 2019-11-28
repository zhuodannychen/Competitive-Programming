import java.util.*;
import java.io.*;

public class Billboard {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("billboard.in"));
        int first_x1 = sc.nextInt();
        int first_y1 = sc.nextInt();
        int first_x2 = sc.nextInt();
        int first_y2 = sc.nextInt();

        int second_x1 = sc.nextInt();
        int second_y1 = sc.nextInt();
        int second_x2 = sc.nextInt();
        int second_y2 = sc.nextInt();

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int area1 = (first_x2 - first_x1) * (first_y2 - first_y1);
        int area2 = (second_x2 - second_x1) * (second_y2 - second_y1);

        int intersect1 = (Math.min(first_x2, x2) - Math.max(first_x1, x1)) * (Math.min(first_y2, y2) - Math.max(first_y1, y1));
        int intersect2 = (Math.min(second_x2, x2) - Math.max(second_x1, x1)) * (Math.min(second_y2, y2) - Math.max(second_y1, y1));
        int sum = 0;
        if ((Math.min(first_x2, x2) - Math.max(first_x1, x1)) >= 0 && (Math.min(first_y2, y2) - Math.max(first_y1, y1)) >= 0)
            sum += intersect1;
        if ((Math.min(second_x2, x2) - Math.max(second_x1, x1)) >= 0 && (Math.min(second_y2, y2) - Math.max(second_y1, y1)) >= 0)
            sum += intersect2;
        PrintWriter pw = new PrintWriter(new File("billboard.out"));
        pw.println(area1 + area2 - sum);
        pw.close();
    }
}
