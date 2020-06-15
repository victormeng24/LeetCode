package ValidPalindrome;

public class ValidPalindrome {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) == ' ' || !isValidChar(s.charAt(begin))) {
                begin++;
                continue;
            }
            if (s.charAt(end) == ' ' || !isValidChar(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(begin++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidChar(char s) {
        return (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z') || (s >= '0' && s <= '9');
    }
}
