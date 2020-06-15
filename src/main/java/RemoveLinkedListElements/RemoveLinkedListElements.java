package RemoveLinkedListElements;

import util.ListNode;
import util.ListUtil;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 1});
        ListUtil.printList(new RemoveLinkedListElements().removeElements(head, 6));
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode next = dummy.next;
        while (next != null) {
            if (next.val == val) {
                pre.next = next.next;
            } else {
                pre = pre.next;
            }
            next = next.next;
        }
        return dummy.next;
    }
}
