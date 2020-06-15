package SortList;

import util.ListNode;
import util.ListUtil;

public class SortList {
    public static void main(String[] args) {
        ListNode l1 = ListUtil.buildListByArray(new int[]{1, 3, 2, 7, 9, 0, 20, 4});
        ListNode l = new SortList().sortList(l1);
        ListUtil.printList(l);
    }
    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeList(sortList(head), sortList(midNext));
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }


}
