import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        List<StringBuilder> list = new ArrayList<>();
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int cur = 0;
            StringBuilder builder = new StringBuilder();
            int b = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int a = num1.charAt(j) - '0';
                int temp = a * b + cur;
                builder.append(temp % 10);
                cur = temp / 10;
            }
            if (cur != 0) {
                builder.append(cur);
            }
            builder.reverse();
            for (int m = 0; m < num2.length() - 1 - i; m++) {
                builder.append(0);
            }
            list.add(builder);
            res = addStrings(res, builder.toString());
        }
        System.out.println(list);
        return res;
    }

    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (m >= 0 || n >= 0 || add != 0) {
            int x = m >= 0 ? num1.charAt(m) - '0' : 0;
            int y = n >= 0 ? num2.charAt(n) - '0' : 0;
            int res = x + y + add;
            stringBuilder.append(res % 10);
            add = res / 10;
            m--;
            n--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        MultiplyStrings strings = new MultiplyStrings();
        System.out.println(strings.multiply("9133", "0"));
    }
}