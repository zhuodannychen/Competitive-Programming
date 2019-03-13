import java.util.*;

public class prob17
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        String str1 = "";
        String str2 = "";
        ArrayList<String> arr2= new ArrayList<>();
        ArrayList<String> arr1= new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println(key + " " + value);

            if(key == ' ')
                key = '_';
            if(value >= 10)
            {
                str2 = "" + key + "[" + value + "]";
                arr2.add(str2);
            }
            else
            {
                str1 = "" + key + "[" + value + "]";
                arr1.add(str1);
            }
        }
        str1 = "";
        str2 = "";
        Collections.reverse(arr1);
        for(int i = 0; i < arr1.size(); i++)
            str1 += arr1.get(i);
        for(int i = 0; i < arr2.size(); i++)
            str2 += arr2.get(i);
        System.out.println(str1 + ";" + str2);
    }
}
