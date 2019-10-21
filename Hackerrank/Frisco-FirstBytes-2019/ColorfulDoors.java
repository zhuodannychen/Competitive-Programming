import java.io.*;
import java.util.*;

public class ColorfulDoors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        boolean r = false;
        boolean g = false;
        boolean b = false;
        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'R')
                r = true;
            else if(str.charAt(i) == 'G')
                g = true;
            else if(str.charAt(i) == 'B')
                b = true;
            else if(str.charAt(i) == 'r' && !r){
                System.out.println("No");
                flag = true;
                break;
            }
                
            else if(str.charAt(i) == 'g' && !g){
                System.out.println("No");
                flag = true;
                break;
            }
            else if(str.charAt(i) == 'b' && !b){
                System.out.println("No");
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("Yes");
    }
}
