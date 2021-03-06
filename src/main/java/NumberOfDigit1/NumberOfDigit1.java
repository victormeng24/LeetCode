package NumberOfDigit1;

public class NumberOfDigit1 {
    /**
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     *
     * 示例:
     *
     * 输入: 13
     * 输出: 6
     * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-digit-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return countr;
    }
}
