import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || numRows < 2) {
            return s;
        }
        List<StringBuilder> stringBuilderList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilderList.add(new StringBuilder());
        }
        int flag = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = stringBuilderList.get(index);
            stringBuilder.append(s.charAt(i));
            index += flag;
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
        }
        String res = "";
        for (StringBuilder stringBuilder : stringBuilderList) {
            res += stringBuilder.toString();
        }
        return res;
    }
}