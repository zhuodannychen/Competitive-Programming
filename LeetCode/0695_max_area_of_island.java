class Solution {
    public static int[] di = {-1, 0, 0, 1};
    public static int[] dj = {0, 1, -1, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        Stack<int[]> s = new Stack<>();
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int k = 0; k < grid.length; k++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[k][j] == 1) {
                    int count = 0;
                    s.add(new int[] {k, j});
                    visited[k][j] = true;
                    while(s.size() != 0) {
                        int[] pos = s.pop();
                        count++;
                        for(int i = 0; i < 4; i++) {
                            int x = pos[0] + di[i];
                            int y = pos[1] + dj[i];
                            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1 || visited[x][y] == true) {
                                continue;
                            }
                            visited[x][y] = true;
                            s.add(new int[] {x, y});
                        }
                    }
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }
}
