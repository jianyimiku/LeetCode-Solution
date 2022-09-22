import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ：sjq
 * @date ：Created in 2022/8/25 09:10
 * @description：
 * @modified By：
 * @version: $
 */
@SuppressWarnings("all")
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new ArrayDeque<>(s.length());
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!queue.isEmpty() && queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}
