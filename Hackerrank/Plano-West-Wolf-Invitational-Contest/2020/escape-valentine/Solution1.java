import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        String[] rows = new String[r];
        for (int i = 0; i < r; i++){
            rows[i] = sc.next();
        }

        Pair[][] portal = new Pair[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                portal[i][j] = new Pair(0, 0, -1);
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i].charAt(j) == '@') {
                    q.add(new Pair(i,j, 0));
                } else if (rows[i].charAt(j) >= 'A' && rows[i].charAt(j) <= 'Z') {
                    if (portal[rows[i].charAt(j) - 'A'][0].x == 0)
                        portal[rows[i].charAt(j) - 'A'][0] = new Pair(i,j, -1);
                    else
                        portal[rows[i].charAt(j) - 'A'][1] = new Pair(i,j, -1);
                }
            }
        }

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        boolean[][] visited = new boolean[r][c];
        Pair teleport = new Pair(0, 0, -1);
        boolean valid = false;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDistance = current.dist;

            if (rows[currentX].charAt(currentY) == '$') {
                System.out.println(currentDistance);
                valid = true;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int i = currentX + di[k];
                int j = currentY + dj[k];

                if (i < 0 || i >= r || j < 0 || j >= c || rows[i].charAt(j) == '#')
                    continue;

                if ((rows[i].charAt(j) == '.' || rows[i].charAt(j) == '$') && !visited[i][j]) {
                    q.add(new Pair(i, j, currentDistance+1));
                    visited[i][j] = true;
                } else if (rows[i].charAt(j) >= 'A' && rows[i].charAt(j) <= 'Z') {
                    if (portal[rows[i].charAt(j) - 'A'][0].x == i && portal[rows[i].charAt(j) - 'A'][0].y == j) {
                        teleport = new Pair(portal[rows[i].charAt(j) - 'A'][1].x, portal[rows[i].charAt(j) - 'A'][1].y, currentDistance+1);
                    } else {
                        teleport = new Pair(portal[rows[i].charAt(j) - 'A'][0].x, portal[rows[i].charAt(j) - 'A'][0].y, currentDistance+1);
                    }
                    if (!visited[teleport.x][teleport.y]) {
                        q.add(teleport);
                        visited[teleport.x][teleport.y] = true;
                    }
                }
            }
        }
        if (!valid)
            System.out.println("Rip Valentines!");
    }
}

class Pair {
    public int x;
    public int y;
    public int dist;
    
    public Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + dist + ")";
    }
}
