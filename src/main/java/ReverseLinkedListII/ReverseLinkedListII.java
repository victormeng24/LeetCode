package ReverseLinkedListII;

import util.ListNode;
import util.ListUtil;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = new ReverseLinkedListII().reverseBetween(head, 1, 5);
        ListUtil.printList(newHead);
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = n - m;
        ListNode pt = dummy;
        while (--m > 0) {
            pt = pt.next;
        }
        ListNode roHead = pt.next, roNext = roHead.next;
        roHead.next = null;
        while (len-- > 0) {
            ListNode tmp = roNext.next;
            roNext.next = roHead;
            roHead = roNext;
            roNext = tmp;
        }
        ListNode roTail = pt.next;
        pt.next = roHead;
        roTail.next = roNext;
        return dummy.next;
    }
}
