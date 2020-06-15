package WordPattern;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        Map<String, String> map = new HashMap<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.get(pattern.substring(i, i + 1)) == null) {
                map.put(pattern.substring(i, i + 1), array[i]);
            } else if (!map.get(pattern.substring(i, i + 1)).equals(array[i])) {
                return false;
            }
        }
        map.clear();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], pattern.substring(i, i + 1));
            } else if (!map.get(array[i]).equals(pattern.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
