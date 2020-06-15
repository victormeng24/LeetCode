package MaximalSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalSlidingWindow {
    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     *  
     * <p>
     * 进阶：
     * <p>
     * 你能在线性时间复杂度内解决此题吗？
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) return new int[0];
        if (k == 1) return nums;
        Deque<Integer> queue = new LinkedList<>();
        int res[] = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            cleanDequeue(queue, nums, i, k);
            queue.addLast(i);
        }
        res[0] = nums[queue.getFirst()];
        for (int i = k; i < len; i++) {
            cleanDequeue(queue, nums, i, k);
            queue.addLast(i);
            res[i - k + 1] = nums[queue.getFirst()];
        }
        return res;
    }

    public void cleanDequeue(Deque<Integer> queue, int[] nums, int i, int k) {
        if (!queue.isEmpty() && queue.getFirst() == i - k) {
            queue.removeFirst();
        }
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
            queue.removeLast();
        }
    }
}
