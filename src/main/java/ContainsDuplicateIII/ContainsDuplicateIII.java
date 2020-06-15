package ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {


    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }
}
