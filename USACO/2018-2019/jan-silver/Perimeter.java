import java.util.*;
import java.io.*;

class Perimeter {
    public static int[] di = {0, 0, 1, -1};
    public static int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("perimeter.in"));
        int n = sc.nextInt();
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] str = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                ch[i][j] = str[j];
            }
        }
        int[] ans = floodfill(ch);
        PrintWriter pw = new PrintWriter(new File("perimeter.out"));
        pw.println(ans[0] + " " + ans[1]);
        pw.close();
    }

    public static int[] floodfill(char[][] grid) {
        Stack<int[]> s = new Stack<>();
        if(grid.length == 0)
            return new int[] {0,0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] ans = new int[2];
        int max_area = 0;
        int min_perimeter = Integer.MAX_VALUE;

        for(int k = 0; k < grid.length; k++) {
            for(int j = 0; j < grid[0].length; j++) {
                int count_perimeter = 0;
                int count_area = 0;
                if(grid[k][j] == '#' && !visited[k][j]) {
                    s.add(new int[] {k, j});
                    visited[k][j] = true;
                    while(s.size() != 0) {
                        ++count_area;
                        int[] pos = s.pop();
                        for(int i = 0; i < 4; i++) {
                            int x = pos[0] + di[i];
                            int y = pos[1] + dj[i];
                            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '.') {
                                count_perimeter++;
                                continue;
                            } else if (visited[x][y])
                                continue;
                            visited[x][y] = true;
                            s.add(new int[] {x, y});
                        }
                    }
                }
                if (count_area > max_area) {
                    max_area = count_area;
                    min_perimeter = count_perimeter;
                } else if (count_area == max_area) {
                    min_perimeter = Math.min(min_perimeter, count_perimeter);
                }
            }
        }
        ans[0] = max_area;
        ans[1] = min_perimeter;
        return ans;
    }
}
