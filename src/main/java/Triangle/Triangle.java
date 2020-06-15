package Triangle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> input = new LinkedList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));
        System.out.println(new Triangle().minimumTotal(input));
    }
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * <p>
     * 例如，给定三角形：
     * <p>
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * <p>
     * 说明：
     * <p>
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }
}
