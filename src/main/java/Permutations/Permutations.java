package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations().permute(new int[]{});
        System.out.println(result);
    }

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, 0, nums.length - 1, nums);
        return result;
    }

    public void helper(List<List<Integer>> result, int begin, int end, int[] nums) {
        if (begin == end) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(nums, begin, i);
            helper(result, begin + 1, end, nums);
            swap(nums, begin, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
