import java.io.*;
import java.util.*;

public class Solution2 {
    
    static List<Tele> teleporters;
    static int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(), C = scanner.nextInt();
        scanner.nextLine();
        teleporters = new ArrayList<>();
        char[][] map = new char[R][C];
        int[][] spaces = new int[R][C];
        Coord start = null;
        for (int i = 0; i < R; ++i) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < C; ++j) {
                map[i][j] = arr[j];
                spaces[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == '@')
                    start = new Coord(i, j);
                if (map[i][j] == '#')
                    spaces[i][j] = -1;
                else if (map[i][j] >= 'A' && map[i][j] <= 'Z')
                    new Tele(map[i][j], new Coord(i, j));
            }
        }
        Queue<Coord> queue = new LinkedList<>();
        queue.add(start);
        spaces[start.r][start.c] = 0;
        while (! queue.isEmpty()) {
            Coord next = queue.remove();
            int num = spaces[next.r][next.c];
            for (int[] a : dir) {
                Coord next2 = new Coord(next.r + a[0], next.c + a[1]);
                if (next2.out(R, C))
                    continue;
                Coord next3 = getNext(next2);
                if (next3 != null) next2 = next3;
                if (spaces[next2.r][next2.c] > num + 1) {
                    spaces[next2.r][next2.c] = num + 1;
                    queue.add(next2);
                    if (map[next2.r][next2.c] == '$') {
                        System.out.println(num + 1);
                        return;
                    }
                }
            }
        }
        System.out.println("Rip Valentines!");
    }
    
    static Coord getNext(Coord c) {
        for (Tele t : teleporters) {
            if (t.c1.r == c.r && t.c1.c == c.c)
                return t.c2;
            else if (t.c2.r == c.r && t.c2.c == c.c)
                return t.c1;
        }
        return null;
    }
    
    static class Coord {
        int r, c;
        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        boolean out(int R, int C) {
            return r < 0 || c < 0 || r >= R || c >= C;
        }
    }
    
    static class Tele {
        Coord c1, c2;
        char id;
        public Tele(char id, Coord c1) {
            for (Tele t : teleporters)
                if (t.id == id) {
                    t.c2 = c1;
                    return;
                }
            this.id = id;
            this.c1 = c1;
            teleporters.add(this);
        }
    }
}
