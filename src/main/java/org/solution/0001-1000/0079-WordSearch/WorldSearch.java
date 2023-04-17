@SuppressWarnings("all")
public class WorldSearch {
    int m, n;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;


    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] && dfs(board, word, index + 1, newx, newy)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        WorldSearch worldSearch = new WorldSearch();
        System.out.println(worldSearch.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }
}