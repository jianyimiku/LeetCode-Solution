import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 表示拼出长度为i所需要单词数量
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                int n = word.length();
                // 表示长度比这个单词小拼不出
                if (i - n < 0) continue;
                // 要匹配的长度
                String needToCompare = s.substring(i - n, i);
                if (needToCompare.equals(word)) {
                    if (i - n == 0) {
                        dp[i] = dp[i - n] + 1;
                    } else if (dp[i - n] > 0) {
                        dp[i] = dp[i - n] + 1;
                    }
                }
            }
        }
        return dp[s.length()] > 0;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}