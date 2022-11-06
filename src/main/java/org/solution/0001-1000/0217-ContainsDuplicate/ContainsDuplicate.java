import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            if (set.contains(e)) {
                return true;
            } else {
                set.add(e);
            }
        }
        return false;
    }
}