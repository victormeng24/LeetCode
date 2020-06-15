package GroupAnagrams;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "ate", "tan", "ant"}));
    }
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                result.add(list);
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        return result;
    }
}
