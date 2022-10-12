@SuppressWarnings("all")
class NumIslands {
    char[][] grids;
    boolean[][] isVisited;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grids = grid;
        this.isVisited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j) {
        if (grids[i][j] != '1') {
            return;
        }

        if (grids[i][j] == '1') {
            isVisited[i][j] = true;
        }

        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newX < grids.length && newY >= 0 &&
                    newY < grids[0].length && !isVisited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }
}