package InterleavingString;

public class InterleavingString {
    /**
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interleaving-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && res[0][j - 1]) res[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && res[i - 1][0]) res[i][0] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                if ((s3.charAt(k) == s1.charAt(i - 1) && res[i - 1][j]) || (s3.charAt(k) == s2.charAt(j - 1) && res[i][j - 1]))
                    res[i][j] = true;
            }
        }
        return res[m][n];
    }
}
