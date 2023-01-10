@SuppressWarnings("all")
class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        trimeSpace(stringBuilder, s);
        reverWord(stringBuilder, 0, stringBuilder.length() - 1);
        reverEachWorld(stringBuilder);
        return stringBuilder.toString();
    }


    private void reverWord(StringBuilder stringBuilder, int left, int right) {
        while (left < right) {
            char temp = stringBuilder.charAt(right);
            stringBuilder.setCharAt(right, stringBuilder.charAt(left));
            stringBuilder.setCharAt(left, temp);
            left++;
            right--;
        }
    }


    private void reverEachWorld(StringBuilder stringBuilder) {
        int left = 0;
        int right = 0;
        while (left < stringBuilder.length()) {
            while (right < stringBuilder.length() && stringBuilder.charAt(right) != ' ') {
                right++;
            }
            reverWord(stringBuilder, left, right - 1);
            right++;
            left = right;
        }
    }


    /**
     * 去除空格
     *
     * @param s
     * @return
     */
    private void trimeSpace(StringBuilder stringBuilder, String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去除两边空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        while (left <= right) {
            if (s.charAt(left) != ' ') {
                stringBuilder.append(s.charAt(left));
            } else if (s.charAt(left - 1) != ' ') {
                stringBuilder.append(s.charAt(left));
            }
            left++;
        }
    }

    public static void main(String[] args) {
        ReverseWords words = new ReverseWords();
        System.out.println(words.reverseWords("a good   example"));
    }
}