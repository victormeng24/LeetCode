package MajorityElementII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    /**
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * <p>
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: [3]
     * 示例 2:
     * <p>
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     * 通过次数14,094提交次数32,811
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if (nums.length == 1) return Arrays.asList(nums[0]);
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }
        return result;
    }
}
