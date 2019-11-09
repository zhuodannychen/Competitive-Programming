import java.util.*;
import java.io.*;

public class Lifeguard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = convert(sc.next());
        }
        for(int i = 0; i < n; i++){
            end[i] = convert(sc.next());
        }

        Arrays.sort(start); Arrays.sort(end);
        int count = 0;
        int answer = 0;
        int start_index = 0;
        int end_index = 0;
        int i = start[0];
        int max = end[n-1];
        while(i < max){
            //System.out.println(i + " " + start_index + " " + end_index + " " + answer + " " + count);
            if(i == end[end_index]){
                if(end_index < n - 1)
                    end_index++;
                else
                    i++;
                count--;
                continue;
            }
            if(i == start[start_index]){
                if(start_index < n - 1)
                    start_index++;
                else
                    i++;
                count++;
                continue;
            }
            if(count != 0)
                answer++;
            i++;
        }
        System.out.println(answer + 1);
    }

    public static int convert(String str){
        String[] arr = str.split(":");
        int hours = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int total = hours * 60 + min;
        return total;
    }
}
