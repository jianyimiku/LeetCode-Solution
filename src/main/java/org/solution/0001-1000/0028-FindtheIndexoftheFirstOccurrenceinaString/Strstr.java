import java.util.Arrays;

@SuppressWarnings("all")
public class Strstr {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        return indexOf(haystack.toCharArray(), haystackLen, needle.toCharArray(), needleLen);
    }


    public int indexOf(char[] haystack, int haystackLen, char[] needle, int needleLen) {
        int[] nexts = generateNext(needle, needleLen);

        int j = 0;
        for (int i = 0; i < haystackLen; i++) {
            while (j != 0 && haystack[i] != needle[j]) {
                j = nexts[j - 1] + 1;
                // TODO 提前结束优化
            }

            if (haystack[i] == needle[j]) {
                j++;
            }

            if (j == needleLen) {
                return i - j + 1;
            }
        }
        return -1;
    }


    /**
     * 对需要匹配的字符串生成next数组方便进行回退
     *
     * @param needle
     * @param needlen
     * @return
     */
    public int[] generateNext(char[] needle, int needlen) {
        int[] next = new int[needlen];

        next[0] = -1;
        int k = -1;
        for (int i = 1; i < needlen; i++) {
            while (k != -1 && needle[k + 1] != needle[i]) {
                k = next[k];
            }

            if (needle[k + 1] == needle[i]) {
                ++k;
            }
            next[i] = k;
        }
        System.out.println(Arrays.toString(next));
        return next;
    }


    public static void main(String[] args) {
        Strstr strstr = new Strstr();
        System.out.println(strstr.strStr("sadbutsad", "addad"));
    }
}