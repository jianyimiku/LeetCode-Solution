import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
class GenerateParentheses {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        dfs(n, 0, 0, "");
        return result;
    }


    public void dfs(int n, int left, int right, String res) {
        if (left == n && right == n) {
            result.add(res);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(n, left + 1, right, res + "(");
        }

        if (right < n) {
            dfs(n, left, right + 1, res + ")");
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses
                = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(1));
    }
}