package MaximumSubarray;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
