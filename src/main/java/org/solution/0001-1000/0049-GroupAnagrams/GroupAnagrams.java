import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
@SuppressWarnings("all")
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
        // 或者用HashMap<String,List<String>>进行存储手动进行排序放入
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}