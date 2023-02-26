package org.solution.origin.bit;

/**
 * @author ：sjq
 * @date ：Created in 2023/2/16 09:24
 * @description：
 * @modified By：
 * @version: $
 */
public class BitOperation {
    public long add(long a, long b) {
        long ans = 0;
        while (b != 0) {
            ans = a ^ b;
            // 余数
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public long mul(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans += a;
            }
            b >>= 1;
            a += a;
        }
        return ans;
    }


    public static void main(String[] args) {
        BitOperation bitOperation = new BitOperation();
        System.out.println(bitOperation.add(18, 1));
    }
}
