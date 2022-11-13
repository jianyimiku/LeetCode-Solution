
@SuppressWarnings("all")
class AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int extra = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (m >= 0 && n >= 0) {
            int a = num1.charAt(m) - '0';
            int b = num2.charAt(n) - '0';

            int res = a + b + extra;

            extra = res / 10;
            stringBuilder.append(res % 10);

            m--;
            n--;
        }

        while (m >= 0) {
            int a = num1.charAt(m) - '0';

            int res = a + extra;

            extra = res / 10;
            stringBuilder.append(res % 10);

            m--;
        }
        while (n >= 0) {
            int b = num2.charAt(n) - '0';
            int res = b + extra;
            extra = res / 10;
            stringBuilder.append(res % 10);
            n--;
        }
        if (extra != 0) {
            stringBuilder.append(extra);
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("0", "0"));
    }
}