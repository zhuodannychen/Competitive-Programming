class Solution {
    public int[][] floodFill(int[][] grid, int r0, int c0, int color) {
        Stack<int[]> s = new Stack<>();
        //int color = grid[r0][c0];
        int[] di = {-1, 0, 0, 1};
        int[] dj = {0, 1, -1, 0};
        int color_original = grid[r0][c0];
        if(color == color_original)
            return grid;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        s.add(new int[] {r0, c0});
        while(!s.empty()) {
            int[] pos = s.pop();
            for(int k = 0; k < 4; k++) {
                int dx = pos[0] + di[k];
                int dy = pos[1] + dj[k];
                if(dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length || grid[dx][dy] != color_original)
                    continue;
                grid[dx][dy] = color;
                s.add(new int[] {dx, dy});
            }
        }
        grid[r0][c0] = color;
        return grid;
    }
}
