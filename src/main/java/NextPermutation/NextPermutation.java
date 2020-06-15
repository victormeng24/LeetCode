package NextPermutation;


public class NextPermutation {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * 通过次数55,236提交次数166,548
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] num) {
        //1.找到最后一个升序位置pos
        int pos = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                pos = i - 1;
                break;
            }
        }

        //2.如果不存在升序，即这个数是最大的，那么反排这个数组
        if (pos < 0) {
            reverse(num, 0, num.length - 1);
            return;
        }

        //3.存在升序，那么找到pos之后最后一个比它大的位置
        for (int i = num.length - 1; i > pos; i--) {
            if (num[i] > num[pos]) {
                int tmp = num[i];
                num[i] = num[pos];
                num[pos] = tmp;
                break;
            }
        }

        //4.反排pos之后的数
        reverse(num, pos + 1, num.length - 1);
    }

    public void reverse(int[] num, int begin, int end) {
        int l = begin, r = end;
        while (l < r) {
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
    }
}
