@SuppressWarnings("all")
class StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        // 取出前导空格
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // 如果i超过字符串长度了
        if (i >= s.length()) {
            return 0;
        }
        int res = 0;
        // 继续判断正负号
        boolean negative = false;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            negative = s.charAt(i) == '-' ? true : false;
            i++;
        } else if (Character.isDigit(s.charAt(i))) {
            res = res * 10 + s.charAt(i) - '0';
            i++;
        } else {
            return 0;
        }
        // 继续读取数字
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (negative) {
                if ((-res < Integer.MIN_VALUE / 10)
                        || ((-res == Integer.MIN_VALUE / 10) && (-(s.charAt(i) - '0') < Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if ((res > Integer.MAX_VALUE / 10) || ((res == Integer.MAX_VALUE / 10)
                        && ((s.charAt(i) - '0') > Integer.MAX_VALUE % 10))) {
                    return Integer.MAX_VALUE;
                }
            }
            res = res * 10 + s.charAt(i) - '0';
            i++;
        }
        return res = negative ? -res : res;
    }


    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi(" "));
    }
}