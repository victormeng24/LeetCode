package DecodeWays;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226"));
    }

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2:
     * <p>
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decode-ways
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.length() == 0) return 0;
        if (s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = (s.charAt(0) != '0' && s.charAt(1) != '0' ? 1 : 0) + ((s.charAt(0) != '0' && ((s.charAt(0) - '0') * 10 + s.charAt(1) - '0') <= 26) ? 1 : 0);
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') dp[i] += dp[i - 1];
            if (s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0') <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length() - 1];
    }
}
