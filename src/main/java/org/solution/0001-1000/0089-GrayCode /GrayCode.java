import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int limit = 1 << n;
        for (int i = 0; i < limit; i++) {
            res.add((i >> 1) ^ i);
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(5));
    }
}