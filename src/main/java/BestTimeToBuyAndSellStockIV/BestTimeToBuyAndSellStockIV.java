package BestTimeToBuyAndSellStockIV;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        // day + sell count + buy or not
        int n = prices.length;
        // validate input 1
        if (k <= 0 || n == 0) return 0;

        // validate input 2 : if k is large enough, the question will be the same as question II.
        if (k >= n / 2) {
            int result = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i - 1], dp[i - 1][j][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i - 1], dp[i - 1][j][1]);
            }
        }
        return dp[dp.length - 1][k][0];
    }
}
