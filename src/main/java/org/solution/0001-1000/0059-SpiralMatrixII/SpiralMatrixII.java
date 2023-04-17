import java.util.Arrays;

@SuppressWarnings("all")
class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index;
                index++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = index;
                index++;
            }
            right--;
            if (left > right) {
                break;
            }
            if (top > bottom) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[bottom][i] = index;
                index++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = index;
                index++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix(5)));
    }
}