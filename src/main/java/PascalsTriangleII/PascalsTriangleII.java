package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * <p>
     * <p>
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 3
     * 输出: [1,3,3,1]
     * 进阶：
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j >= 1; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
