package JumpGameII;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 1, 1, 4}));
    }
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 示例:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 说明:
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int curMax = 0;
        int curReach = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curReach < i) {
                curReach = curMax;
                step++;
            }
            curMax = Math.max(curMax, nums[i] + i);
        }
        return step;
    }
}
