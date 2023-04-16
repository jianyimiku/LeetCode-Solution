import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class SolveQueens {
    // 行有没有
    boolean[] row;
    // 列有没有
    boolean[] col;
    // 主斜线
    boolean[] main;
    // 副斜线
    boolean[] sub;
    char[][] magrid;

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n];
        col = new boolean[n];
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        magrid = new char[n][n];
        for (char[] chars : magrid) {
            Arrays.fill(chars, '.');
        }
        dfs(0, n);
        return res;
    }


    /**
     * index表示第几行
     *
     * @param index
     */
    private void dfs(int index, int n) {
        if (index == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < magrid.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < magrid[0].length; j++) {
                    stringBuilder.append(magrid[i][j]);
                }
                list.add(stringBuilder.toString());
            }
            res.add(list);
            return;
        }

        for (int j = 0; j < magrid[0].length; j++) {
            // 当前行 列 斜线均没有
            if (!row[index] && !col[j] && !main[j - index + n - 1]
                    && !sub[j + index]) {
                row[index] = true;
                col[j] = true;
                main[j - index + n - 1] = true;
                sub[j + index] = true;
                magrid[index][j] = 'Q';
                dfs(index + 1, n);
                magrid[index][j] = '.';
                row[index] = false;
                col[j] = false;
                main[j - index + n - 1] = false;
                sub[j + index] = false;
            }
        }
    }

    public static void main(String[] args) {
        SolveQueens solveQueens = new SolveQueens();
        System.out.println(solveQueens.solveNQueens(9));
    }
}