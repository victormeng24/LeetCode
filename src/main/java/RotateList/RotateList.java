package RotateList;

import util.ListNode;
import util.ListUtil;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 2, 3, 4, 5});
        ListNode res = new RotateList().rotateRight(head, 5);
        ListUtil.printList(res);
    }
    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     * <p>
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int toMove = len - k;
        ListNode pointer = dummy;
        while (toMove-- > 0) {
            pointer = pointer.next;
        }
        ListNode newHead = pointer.next;
        pointer.next = null;
        dummy.next = newHead;
        tail.next = head;
        return dummy.next;
    }
}
