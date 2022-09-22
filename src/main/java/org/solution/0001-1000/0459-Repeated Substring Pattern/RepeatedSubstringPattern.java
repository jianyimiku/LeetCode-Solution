
@SuppressWarnings("all")
class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String source = s + s;
        String pattern = s;
        return kmp(source.substring(1, source.length() - 1), s);
    }


    /**
     * 生成Next数组
     *
     * @return
     */
    private int[] buildNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    /**
     * kmp算法
     *
     * @param source
     * @param pattern
     * @return
     */
    public boolean kmp(String source, String pattern) {
        int[] next = buildNext(pattern);
        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            while (j > 0 && source.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            if (source.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        RepeatedSubstringPattern substringPattern = new RepeatedSubstringPattern();
        System.out.println(substringPattern.repeatedSubstringPattern("abcabcabcabc"));
    }
}