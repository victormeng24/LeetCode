package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                findSum(nums, j + 1, nums.length - 1, nums[i], nums[j], target);
            }
        }
        return list;
    }

    public void findSum(int[] a, int begin, int end, int aim, int aim2, int target) {
        int l = begin, r = end;
        while (l < r) {
            int result = a[l] + a[r] + aim + aim2;
            if (result == target) {

                list.add(Arrays.asList(aim, aim2, a[l], a[r]));
                while (l < r && a[l + 1] == a[l]) l++;
                while (l < r && a[r] == a[r - 1]) r--;
                r--;
                l++;
            }
            if (result > target) r--;
            if (result < target) l++;
        }
    }
}
