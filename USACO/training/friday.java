import java.io.*;
import java.util.*;

public class friday
{
    public static void main(String[] args) throws IOException
    {

        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter pw = new PrintWriter(new File("friday.out"));
        int years = sc.nextInt();
        int[] tracker = new int[7];
        Arrays.fill(tracker, 0);
        int[] year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int calenderDay = 0;

        for(int i = 1900; i < 1900 + years; i++)
        {

            for(int j = 0; j < 12; j++)
            {

                if(isLeapYear(i))
                {
                    int day = (calenderDay) % 7;
                    tracker[day]++;
                    calenderDay += leapYear[j];
                }
                else
                {
                    int day = (calenderDay) % 7;
                    tracker[day]++;
                    calenderDay += year[j];
                    //System.out.println(calenderDay);
                }
            }
        }

        System.out.println(tracker[0] + " " + tracker[1] + " " + tracker[2] + " " + tracker[3] + " " + tracker[4] + " " + tracker[5] + " " + tracker[6]);
        pw.println(tracker[0] + " " + tracker[1] + " " + tracker[2] + " " + tracker[3] + " " + tracker[4] + " " + tracker[5] + " " + tracker[6]);
        pw.close();
    }

    public static boolean isLeapYear(int year)
    {
        if(year % 100 == 0)
        {
            return year % 400 == 0;
        }
        else if(year % 4 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
