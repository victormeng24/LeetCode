package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 通过次数43,778提交次数59,633
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combinations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, n, k, new ArrayList<>(), 1);
        return result;
    }

    public void traverse(List<List<Integer>> result, int n, int k, List<Integer> list, int begin) {
        if (k == 0) {
            List<Integer> copy = new ArrayList<>(list);
            result.add(copy);
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            traverse(result, n, k - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
