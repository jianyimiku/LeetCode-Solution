import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(new int[][]{
                {1,2},{3,4}
        }));
    }
}