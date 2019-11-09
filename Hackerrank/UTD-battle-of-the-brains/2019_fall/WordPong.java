import java.util.*;
import java.io.*;

public class WordPong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String left = "qwertasdfgzxcvb";
        String right = "poiuylkjhmn";
        int n = sc.nextInt();

        for(int j = 0; j < n; j++) {
            String c = sc.next();
            boolean l = false;
            boolean r = false;
            boolean flag = false;
            for(int i = 0; i < c.length(); i++){
                if(left.contains(c.substring(i, i+1)) && l){
                    System.out.println(c + " does not play ping pong");
                    flag = true;
                    break;
                } else if(right.contains(c.substring(i, i+1)) && r){
                    System.out.println(c + " does not play ping pong");
                    flag = true;
                    break;
                } else if(left.contains(c.substring(i, i+1)) && !l){
                    l = true;
                    r = false;
                } else {
                    l = false;
                    r = true;
                }
            }
            if(!flag)
                System.out.println(c + " plays ping pong");

        }

    }
}
