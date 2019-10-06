import java.io.*;
import java.util.*;

public class Lines {

    private static char[][] arr;
    private static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x_wins = 0;
        int o_wins = 0;
        while (T-- > 0) {
            int c = sc.nextInt();
            int r = sc.nextInt();
            K = sc.nextInt();
            arr = new char[r][c];
            ArrayList<Point> x = new ArrayList<>();
            ArrayList<Point> o = new ArrayList<>();
            for (int i = 0, j = 0; i < r; i++, j = 0) {
                for (char a : sc.next().toCharArray()) {
                    if (a == 'x') {
                        x.add(new Point(i, j));
                    } else if (a == 'o') {
                        o.add(new Point(i, j));
                    }
                    arr[i][j++] = a;
                }
            }
            boolean flag = false;
            //ZSystem.out.println(Arrays.deepToString(arr));
            for(Point p : x) {
                if(find('x', p.r, p.c)){
                    x_wins++;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                for(Point p : o) {
                    if(find('o', p.r, p.c)){
                        o_wins++;
                        break;
                    }
                }
            }
        }
        System.out.println(x_wins + ":" + o_wins);
    }

    public static boolean find(char letter, int rows, int columns) {
        if(alg(letter, rows, columns, 1, -1, 0))
            return true;
        if(alg(letter, rows, columns, 1, 1, 0))
            return true;
        if(alg(letter, rows, columns, 1, 0, 1))
            return true;
        if(alg(letter, rows, columns, 1, 0, -1))
            return true;
        if(alg(letter, rows, columns, 1, 1, -1))
            return true;
        if(alg(letter, rows, columns, 1, 1, 1))
            return true;
        return false;
    }
    public static boolean alg(char letter, int rows, int columns, int count, int rIncrease, int cIncrease) {
        if (rows == arr.length || rows < 0 || columns < 0 || columns == arr[rows].length)
            return false;
        if(arr[rows][columns] == letter) {
            if(K == count) {
                return true;
            }
            return alg(letter, rows + rIncrease, columns + cIncrease, count + 1, rIncrease, cIncrease);
        }
        return false;
    }
    private static class Point {
        private int r, c;

        public Point(int row, int col) {
            r = row;
            c = col;
        }
    }
}
