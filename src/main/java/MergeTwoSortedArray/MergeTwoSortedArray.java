package MergeTwoSortedArray;

public class MergeTwoSortedArray {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
     * <p>
     *  
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     * <p>
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPointer = m - 1;
        int nPointer = n - 1;
        while (mPointer >= 0 && nPointer >= 0) {
            if (nums1[mPointer] > nums2[nPointer]) {
                nums1[mPointer + nPointer + 1] = nums1[mPointer];
                mPointer--;
            } else {
                nums1[mPointer + nPointer + 1] = nums2[nPointer];
                nPointer--;
            }
        }
        while (nPointer >= 0) {
            nums1[nPointer] = nums2[nPointer--];
        }
    }
}
