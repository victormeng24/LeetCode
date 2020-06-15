package ThreeSumCloest;

import java.util.Arrays;

public class ThreeSumCloest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[begin] + nums[end] + tmp;
                if (Math.abs(sum - target) < minGap) {
                    res = sum;
                    minGap = Math.abs(sum - target);
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    begin++;
                } else return res;
            }
        }
        return res;
    }
}
