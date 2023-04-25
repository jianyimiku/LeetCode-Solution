@SuppressWarnings("all")
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String res = "11";
        for (int i = 3; i <= n; i++) {
            res = checkString(res);
        }
        return res;
    }

    public String checkString(String s) {
        int count = 1;
        int n = s.length();
        int l = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (l < n - 1) {
            while (l < n - 1 && s.charAt(l) == s.charAt(l + 1)) {
                count++;
                l++;
            }
            stringBuilder.append(count).append(s.charAt(l));
            count = 1;
            l++;
        }
        if (l < n) {
            stringBuilder.append(count).append(s.charAt(l));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay andSay = new CountAndSay();
        System.out.println(andSay.countAndSay(5));
    }
}