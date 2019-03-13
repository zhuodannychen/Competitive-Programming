import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class prob10
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            String str = sc.nextLine();
            if(str.contains(":"))
            {

                String[] arr = str.split(":");
                //System.out.println(Arrays.toString(arr));
                LocalDate date = LocalDate.parse(arr[0]);
                int num = Integer.valueOf(arr[1]);
                if(num > 99)
                {
                    date = date.plusYears(num);
                    System.out.println("Will be " + num + " on " + date + " if born on " + arr[0] + " (good job!)");
                }
                else if(num > 0)
                {
                    date = date.plusYears(num);
                    System.out.println("Will be " + num + " on " + date + " if born on " + arr[0]);
                }
                else
                {
                    date = date.plusYears(1);
                    date = date.minusDays(1);
                    System.out.println("Will still be 0 up to " + date + " if born on " + arr[0]);
                }
            }
            else
            {
                String[] arr = str.split(" ");
                String str1 = arr[0];
                str1 = str1.substring(0, str1.indexOf("-"));
                String str2 = arr[1];
                str2 = str2.substring(0, str2.indexOf("-"));
                int year1 = Integer.valueOf(str1);
                int year2 = Integer.valueOf(str2);
                System.out.println("If born on " + arr[0] + ", will be " + (year2-year1) + " years old on " + arr[1]);
            }
        }
    }
}
