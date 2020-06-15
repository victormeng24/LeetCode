package AddTwoNumbers;

import util.ListNode;
import util.ListUtil;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListUtil.buildListByArray(new int[]{2,4,3});
        ListNode l2 = ListUtil.buildListByArray(new int[]{5,6,4});
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListUtil.printList(res);
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recurse(l1, l2, 0);
    }

    public ListNode recurse(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int l1Val = l1 == null ? 0 : l1.val;
        int l2Val = l2 == null ? 0 : l2.val;
        int currentBitResult = (l1Val + l2Val + carry) % 10;
        int toCarry = (l1Val + l2Val + carry) / 10;
        ListNode tmpNode = new ListNode(currentBitResult);
        ListNode next = recurse(l1 == null ? null : l1.next, l2 == null ? null : l2.next, toCarry);
        if (next != null) {
            tmpNode.next = next;
        }
        return tmpNode;
    }
}
