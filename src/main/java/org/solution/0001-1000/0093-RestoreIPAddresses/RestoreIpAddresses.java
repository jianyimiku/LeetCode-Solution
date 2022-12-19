import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class RestoreIpAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // dfs
        int len = s.length();
        if (len > 12 || len < 4) {
            return res;
        }
        dfs(s, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String s, int index, int begin, List<String> param) {
        // 表示分隔完成
        if (begin == s.length()) {
            if (index == 4) {
                res.add(param.stream().collect(Collectors.joining(".")));
            }
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            // 可以提前终止判断的条件 表示剩下的没有用完所有的字符
            if ((4 - index) * 3 < s.length() - i) {
                break;
            }
            String subString = s.substring(begin, i + 1);
            if (isValidIp(subString)) {
                param.add(subString);
                dfs(s, index + 1, i + 1, param);
                param.remove(param.size() - 1);
            }
        }
    }

    private boolean isValidIp(String append) {
        int left = 0;
        int right = append.length();
        if (append.length() > 1 && append.charAt(left) == '0') {
            return false;
        }
        long res = Long.valueOf(append);
        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("101023"));
    }
}