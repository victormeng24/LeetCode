package MaximalRectangle;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * 示例:
     *
     * 输入:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * 输出: 6
     * 通过次数25,665提交次数56,275
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param heights
     * @return
     */
    // Get the maximum area in a histogram given its heights
    public int leetcode84(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, leetcode84(dp));
        } return maxarea;
    }
}
