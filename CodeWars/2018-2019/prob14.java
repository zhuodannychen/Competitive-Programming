import java.util.*;

public class prob14
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[10];
        arr[0] = one;
        arr[1] = two;
        for(int i = 2; i < n; i++)
        {
            arr[i] = one + two;
            one = two;
            two = arr[i];
        }
        for(int i = 0; i < n - 1; i++)
            System.out.print(arr[i] + ",");
        System.out.print(arr[n-1]);
    }
}
