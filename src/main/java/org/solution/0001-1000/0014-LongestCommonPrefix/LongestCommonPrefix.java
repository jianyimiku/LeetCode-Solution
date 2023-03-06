@SuppressWarnings("all")
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String compare = strs[i];
            commonPrefix = commonPrefix.length() <= compare.length() ?
                    getCommonPrefix(commonPrefix, compare) : getCommonPrefix(compare, commonPrefix);
            if (commonPrefix.equals("")) {
                break;
            }
        }
        return commonPrefix;
    }

    public String getCommonPrefix(String cur, String compare) {
        int res = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == compare.charAt(i)) {
                res++;
            } else {
                break;
            }
        }
        return cur.substring(0, res);
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}