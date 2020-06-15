package SpiralMaxtrix;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

    }

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * <p>
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            r--;
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    result.add(matrix[b][i]);
                }
            }
            b--;
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    result.add(matrix[i][l]);
                }
            }
            l++;
        }
        return result;
    }
}
