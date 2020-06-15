package PerfectSquares;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(13));
    }
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     * <p>
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[j * j] + dp[i - j * j], dp[i]);
            }
        }
        return dp[n];
    }
}
