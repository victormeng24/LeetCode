package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案。
     *
     * 示例:
     *
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private List<List<String>> list = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        char[] res = s.toCharArray();
        getList(new ArrayList<String>(), 0, res);
        return list;
    }

    public void getList(List<String> sublist, int index, char[] s) {
        if (index == s.length) {
            List<String> newlist = new ArrayList<>(sublist);
            list.add(newlist);
        }
        for (int i = index; i < s.length; i++) {
            if (isPalindrome(index, i, s)) {
                sublist.add(String.valueOf(s, index, i - index + 1));
                getList(sublist, i + 1, s);
                sublist.remove(sublist.size() - 1);
            }
        }

    }

    public boolean isPalindrome(int i, int j, char[] s) {
        for (; i <= j; i++, j--) {
            if (s[i] != s[j]) return false;
        }
        return true;
    }
}
