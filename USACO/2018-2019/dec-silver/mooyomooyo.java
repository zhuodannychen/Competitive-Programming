import java.util.*;
import java.io.*;

class mooyomooyo {
    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<int[]> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("mooyomooyo.in"));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        grid = new int[n][10];
        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < 10; j++) {
                grid[i][j] = Integer.parseInt(str[j]);
            }
        }

        boolean flag = false;
        do {
            flag = false;
            int ans = 0;
            visited = new boolean[n][10];
            gravity();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grid[i][j] != 0 && !visited[i][j]) {
                        ans = floodfill(i, j, grid[i][j]);
                        if (ans >= k) {
                            flag = true;
                            for (int m = 0; m < ans; m++) {
                                int r = arr.get(m)[0];
                                int c = arr.get(m)[1];
                                grid[r][c] = 0;
                            }
                        }
                        arr.clear();
                    }
                }
            }
        } while (flag);

        PrintWriter pw = new PrintWriter(new File("mooyomooyo.out"));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grid[i][j]);
                pw.print(grid[i][j]);
            }
            System.out.println();
            pw.println();
        }
        pw.close();
    }

    public static int[] di = {0, 0, 1, -1};
    public static int[] dj = {-1, 1, 0, 0};
    public static int floodfill(int r, int c, int color) {
        if (r < 0 || r >= n || c < 0 || c >= 10)
            return 0;
        if (grid[r][c] != color || visited[r][c])
            return 0;
        int sum = 1;
        visited[r][c] = true;
        arr.add(new int[] {r, c});
        for (int i = 0; i < 4; i++) {
            sum += floodfill(r + di[i], c + dj[i], color);
        }
        return sum;
    }

    public static void gravity() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.clear();
            for (int j = 0; j < n; j++) {
                if (grid[j][i] != 0) {
                    arr.add(grid[j][i]);
                }
                grid[j][i] = 0;
            }
            int count = n-1;
            for (int j = arr.size() - 1; j >= 0; j--) {
                grid[count][i] = arr.get(j);
                count--;
            }
        }
    }
}
