package NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * <p>
     * <p>
     * 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例:
     * <p>
     * 输入: 4
     * 输出: [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     *  
     * <p>
     * 提示：
     * <p>
     * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2 * n],
                new boolean[2 * n], n, new ArrayList<>(), result);
        return result;
    }

    public void helper(int row, boolean[] col, boolean[] id1, boolean[] id2, int n, List<String> subList,
                       List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(subList));
            return;
        }
        char[] line = new char[n];
        Arrays.fill(line, '.');
        for (int i = 0; i < n; i++) {
            int index1 = n - row + i, index2 = row + i;
            if(!col[i] && !id1[index1] && !id2[index2]) {
                line[i] = 'Q';
                subList.add(String.valueOf(line));
                col[i] = true;
                id1[index1] = true;
                id2[index2] = true;
                helper(row + 1, col, id1, id2, n, subList, result);
                id1[index1] = false;
                id2[index2] = false;
                col[i] = false;
                line[i] = '.';
                subList.remove(subList.size() - 1);
            }
        }

    }

}
