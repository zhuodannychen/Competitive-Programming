import java.util.*;
import java.io.*;
public class Prob01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            System.out.println(sc.nextLine().toLowerCase());
        }
    }
}
