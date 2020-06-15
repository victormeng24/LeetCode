package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * <p>
     * <p>
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
}
