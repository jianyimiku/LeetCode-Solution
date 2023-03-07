import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class LetterCombinations {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }

    private void dfs(String digits, int index, String params) {
        if (index == digits.length()) {
            res.add(params);
            return;
        }
        String str = getStr(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            String next = params + str.charAt(i);
            dfs(digits, index + 1, next);
        }
    }


    public static void main(String[] args) {
        LetterCombinations combinations = new LetterCombinations();
        System.out.println(combinations.letterCombinations("2"));
    }


    private String getStr(Character character) {
        return switch (character) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> "";
        };
    }
}