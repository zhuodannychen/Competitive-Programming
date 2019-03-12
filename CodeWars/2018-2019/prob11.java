import java.util.*;

public class prob11
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        String[] arr = new String[h];
        sc.nextLine();
        for(int i = 0; i < h; i++)
        {
            arr[i] = sc.nextLine();
            //System.out.println(arr[i]);
        }
        //System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        for(int i = h - 1; i >= 0; i--)
            System.out.println(arr[i]);
        int count = 0;
        for(int i = 0; i <= w; i++)
        {
            System.out.print(count%10);
            count++;
        }
    }
}
