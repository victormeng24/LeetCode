package DistinctSubsequences;

public class DistinctSubsequences {
    /**
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     * <p>
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * <p>
     * 题目数据保证答案符合 32 位带符号整数范围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：S = "rabbbit", T = "rabbit"
     * 输出：3
     * 解释：
     * <p>
     * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
     * (上箭头符号 ^ 表示选取的字母)
     * <p>
     * rabbbit
     * ^^^^ ^^
     * rabbbit
     * ^^ ^^^^
     * rabbbit
     * ^^^ ^^^
     * 示例 2：
     * <p>
     * 输入：S = "babgbag", T = "bag"
     * 输出：5
     * 解释：
     * <p>
     * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
     * (上箭头符号 ^ 表示选取的字母)
     * <p>
     * babgbag
     * ^^ ^
     * babgbag
     * ^^    ^
     * babgbag
     * ^    ^^
     * babgbag
     * ^  ^^
     * babgbag
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distinct-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        if (s.length() < t.length()) {
            return 0;
        }
        //递推公式用的
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        //任意一个字符串变换成一个空串都只有一种变换方法
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        //递推公式
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                //如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
