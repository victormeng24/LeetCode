package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
    }
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (nums[begin] + nums[end] > -target) end--;
                else if (nums[begin] + nums[end] < -target) begin++;
                else {
                    result.add(Arrays.asList(target, nums[begin], nums[end]));
                    int mark = nums[begin];
                    while (begin < end && nums[begin] == mark) begin++;
                    end--;
                }
            }
        }
        return result;
    }
}
