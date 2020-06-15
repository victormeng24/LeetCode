package KthLargestElementInAnArray;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int arr[] = {6, 7, 4, 2, 3, 1};
        int res = new KthLargestElementInAnArray().findKthLargest(arr, 6);
        System.out.println(res);
    }
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     * <p>
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        k -= 1;
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int begin, int end) {
        int index = quickSort(nums, begin, end);
        if(index == k) return nums[k];
        else if(index < k) {
            return findKthLargest(nums, k, index + 1, end);
        }
        else return findKthLargest(nums, k, begin, index - 1);
    }

    public int quickSort(int[] arr, int begin, int end) {
        int key = arr[begin];
        int index = begin;
        for (int i = begin + 1; i <= end; i++) {
            if(arr[i] >= key) {
                swap(arr, i, ++index);
            }
        }
        swap(arr, begin, index);
        return index;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
