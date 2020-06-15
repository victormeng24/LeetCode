package LongestValidParentheses;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses2("())"));
    }

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     * <p>
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else if (s.charAt(i) == ')') right++;
            if (left == right) {
                res = Math.max(res, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else if (s.charAt(i) == ')') right++;
            if (left == right) {
                res = Math.max(res, right * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        int res = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                    res = Math.max(res, dp[i + 1]);
                } else {
                    if (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(') {
                        dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
                        res = Math.max(res, dp[i + 1]);
                    }
                }
            }
        }
        return res;
    }
}
