import java.io.*;
import java.util.*;

public class Shuffle {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        
        int n = sc.nextInt();
        int[] moveTo = new int[n+1];
        for(int i = 1; i <= n; i++) {
            moveTo[sc.nextInt()] = i;
        }
        System.out.println(Arrays.toString(moveTo));
        int[] finalLocs = new int[n+1];
        for(int i = 1; i <= n; i++) {
            finalLocs[i] = sc.nextInt();
        }

        int[] originalLocations = new int[n+1];
        for(int finalPosition = 1; finalPosition <= n; finalPosition++) {
            int currentLocation = finalPosition;
            for(int iter = 1; iter <= 3; iter++) {
                currentLocation = moveTo[currentLocation];
            }
            originalLocations[currentLocation] = finalLocs[finalPosition];
        }

        System.out.println(Arrays.toString(originalLocations));
        for(int i = 1; i <= n; i++) {
            pw.println(originalLocations[i]);
        }
        pw.close();
    }
}
