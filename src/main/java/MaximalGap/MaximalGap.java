package MaximalGap;

import java.util.Arrays;

public class MaximalGap {
    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * <p>
     * 如果数组元素个数小于 2，则返回 0。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     * 示例 2:
     * <p>
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     * 说明:
     * <p>
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-gap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] arrmin = new int[nums.length - 1];
        int[] arrmax = new int[nums.length - 1];
        Arrays.fill(arrmin, Integer.MAX_VALUE);
        Arrays.fill(arrmax, Integer.MIN_VALUE);
        for (int i : nums) {
            if (i == min || i == max) continue;
            int k = (i - min) / gap;
            arrmax[k] = Math.max(arrmax[k], i);
            arrmin[k] = Math.min(arrmin[k], i);
        }
        int maxgap = 0;
        int temp = min;
        for (int i = 0; i < arrmin.length; i++) {
            if (arrmin[i] == Integer.MAX_VALUE && arrmax[i] == Integer.MIN_VALUE) continue;
            maxgap = Math.max(arrmin[i] - temp, maxgap);
            temp = arrmax[i];
        }
        maxgap = Math.max(max - temp, maxgap);
        return maxgap;
    }
}
