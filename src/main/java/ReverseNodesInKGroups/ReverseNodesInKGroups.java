package ReverseNodesInKGroups;

import util.ListNode;
import util.ListUtil;

import java.util.List;

public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = new ReverseNodesInKGroups().reverseKGroup(head, 3);
        ListUtil.printList(newHead);
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给你这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     *  
     * <p>
     * 说明：
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while (tail != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode tmpHead = pre.next, nxtStart = tail.next;
            tail.next = null;
            pre.next = reverse(tmpHead);
            tmpHead.next = nxtStart;
            pre = tail = tmpHead;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode nxt = head.next;
        pre.next = null;
        while (nxt != null) {
            ListNode tmp = nxt.next;
            nxt.next = pre;
            pre = nxt;
            nxt = tmp;
        }
        return pre;
    }

}
