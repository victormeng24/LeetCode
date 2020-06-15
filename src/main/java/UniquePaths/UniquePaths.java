package UniquePaths;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7,3));
    }
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例 2:
     * <p>
     * 输入: m = 7, n = 3
     * 输出: 28
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int res[] = new int[m];
        Arrays.fill(res, 1);
        while (--n > 0) {
            for (int i = 1; i < res.length; i++) {
                res[i] += res[i - 1];
            }
        }
        return res[m - 1];
    }
}
