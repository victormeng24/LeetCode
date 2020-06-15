package SummaryRanges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    /**
     * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [0,1,2,4,5,7]
     * 输出: ["0->2","4->5","7"]
     * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
     * 示例 2:
     * <p>
     * 输入: [0,2,3,4,6,8,9]
     * 输出: ["0","2->4","6","8->9"]
     * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/summary-ranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i, j = 0; j < nums.length; ++j){
            i = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                ++j;
            // put the range into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
        }
        return summary;
    }
}
