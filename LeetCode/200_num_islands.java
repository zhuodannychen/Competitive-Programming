class Solution {
    public static int[] di = {-1, 0, 0, 1};
    public static int[] dj = {0, 1, -1, 0};
    
    public int numIslands(char[][] grid) {
        Stack<int[]> s = new Stack<>();
        if(grid.length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int k = 0; k < grid.length; k++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[k][j] == '1' && !visited[k][j]) {
                    count++;
                    s.add(new int[] {k, j});
                    visited[k][j] = true;
                    while(s.size() != 0) {
                        int[] pos = s.pop();
                        for(int i = 0; i < 4; i++) {
                            int x = pos[0] + di[i];
                            int y = pos[1] + dj[i];
                            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1' || visited[x][y]) {
                                continue;
                            }
                            visited[x][y] = true;
                            s.add(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return count;
    }
}

