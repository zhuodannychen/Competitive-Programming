import java.util.*;
public class prob19
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        int key = 0;
        for(int i = 0; i < c.length; i++)
        {
            if(i % 2 == 0)
                key += c[i];
            else
                key -= c[i];
        }
        while(key < 32)
            key+=32;
        while(key > 126)
            key -= 16;
        System.out.println("Key = " + key);

        while(sc.hasNext())
        {
            String r = "";
            char[] str = sc.next().toCharArray();
            for(int i = 0; i < str.length; i++)
            {
                String hex = Integer.toString(str[i] * key, 16);
                r += hex + ",";
            }
            r = r.substring(0, r.length() - 1);
            System.out.println(r);
        }
    }
}
