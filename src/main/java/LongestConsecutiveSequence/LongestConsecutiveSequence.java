package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * <p>
     * 要求算法的时间复杂度为 O(n)。
     * <p>
     * 示例:
     * <p>
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 1;
        int max = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                count = 1;
                int conseutiveNum = num + 1;
                while (set.contains(conseutiveNum)) {
                    count++;
                    conseutiveNum += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
