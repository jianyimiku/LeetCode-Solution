@SuppressWarnings("all")
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] cel = new boolean[9][9];
        boolean[][][] area = new boolean[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '0';
                    if (!row[i][c - 1] && !cel[j][c - 1] &&
                            !area[i / 3][j / 3][c - 1]) {
                        row[i][c - 1] = true;
                        cel[j][c - 1] = true;
                        area[i / 3][j / 3][c - 1] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
    }
}