package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List subList : result) {
            System.out.println(subList);
        }

    }

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        traversal(result, target, candidates, 0, new ArrayList<>());
        return result;
    }

    public void traversal(List<List<Integer>> list, int target, int[] candidates, int i, List<Integer> subList) {
        if (target == 0) {
            List<Integer> copyList = new ArrayList<>(subList);
            list.add(copyList);
            return;
        }
        if (i == candidates.length || candidates[i] > target) return;
        for (int k = i; k < candidates.length; k++) {
            subList.add(candidates[k]);
            traversal(list, target - candidates[k], candidates, k, subList);
            subList.remove(subList.size() - 1);
        }
    }

}
