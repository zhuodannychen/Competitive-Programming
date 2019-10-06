import java.io.*;
import java.util.*;

public class HalfWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int points = sc.nextInt();
        double totalDistance = 0;
        int[] x = new int[points]; int[] y = new int[points];
        for(int i = 0; i < points; i++){
            x[i] = sc.nextInt(); 
            y[i] = sc.nextInt();
        }
        for(int i = 0; i < points - 1; i++){
            totalDistance += distance(x[i], y[i], x[i+1], y[i+1]);
        }
        double halfway = totalDistance / 2;
        double currentDis = 0;
        totalDistance = 0;
        for(int i = 0; i < points - 1; i++){
            currentDis = distance(x[i], y[i], x[i+1], y[i+1]);
            if(currentDis + totalDistance > halfway){
                double frac = (halfway - totalDistance) / (currentDis);
                System.out.printf("%.6f %.6f", (x[i+1] - x[i]) * frac + x[i], (y[i+1] - y[i]) * frac + y[i]);
                break;
            }
            totalDistance += currentDis;
        }
        //System.out.println(halfway);
        //System.out.println(y[count]);
    }
    
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
