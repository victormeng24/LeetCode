package LargestNumber;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
    }
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [10,2]
     * 输出: 210
     * 示例 2:
     * <p>
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if(nums.length == 0) return "";
        String[] helper = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            helper[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(helper, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        if(helper[0].equals("0")) return "0";
        for(String str: helper) {
            sb.append(str);
        }
        return sb.toString();
    }
}
