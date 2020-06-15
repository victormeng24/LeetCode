package SubSets;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        List<List<Integer>> result = new SubSets().subsets(new int[]{1,2,3});
    }
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void traverse(int[] nums, int k, List<Integer> list, List<List<Integer>> result) {
        List<Integer> tmp = new ArrayList<>(list);
        result.add(tmp);
        for (int i = k; i < nums.length; i++) {
            list.add(nums[i]);
            traverse(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
