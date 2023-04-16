@SuppressWarnings("all")
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int index = -1;
        int i = s.length() - 1;
        while (i >= 0) {
            // 找到不是空格的位置
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                return 0;
            }
            index = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            return index - i;
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord lastWord = new LengthOfLastWord();
        System.out.println(lastWord.lengthOfLastWord(""));
    }
}