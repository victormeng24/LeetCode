package SingleNumberII;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{2,2,2,1}));
    }
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,2,3,2]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/single-number-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            count = 0;
            for(int num: nums) {
                if((num & mask) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0) {
                result |= mask;
            }
        }
        return result;
    }
}
