import java.util.*;

public class LockCombination
{
    static int n;
    static int[] rotations;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        rotations = new int[n];
        for (int i = 0; i < n; i++) {
            rotations[i] = sc.nextInt();
        }
        boolean isPossible = checkPossible(0, 0);
        if (isPossible)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean checkPossible(int currentIndex, int totalAngle)
    {

        if (currentIndex == n)
        {
            if (totalAngle==0) return true;
            return false;
        }
        int newIndex = currentIndex + 1;

        return checkPossible(newIndex,(totalAngle + rotations[currentIndex]) % 360) || checkPossible(newIndex, (totalAngle - rotations[currentIndex]) % 360);
    }
}
