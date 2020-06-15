package RemoveNthNodeFromEndOfList;

import util.ListNode;
import util.ListUtil;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode l = ListUtil.buildListByArray(arr);
        ListNode head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(l, 1);
        ListUtil.printList(head);
    }
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * <p>
     * 你能尝试使用一趟扫描实现吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nxt = dummy;
        while (n-- > 0) {
            nxt = nxt.next;
        }
        while (nxt.next != null) {
            pre = pre.next;
            nxt = nxt.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
