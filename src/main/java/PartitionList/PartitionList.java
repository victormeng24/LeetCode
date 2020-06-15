package PartitionList;

import util.ListNode;
import util.ListUtil;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 4, 3, 2, 5, 2});
        head = new PartitionList().partition(head, 3);
        ListUtil.printList(head);
    }
    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * <p>
     * 你应当保留两个分区中每个节点的初始相对位置。
     * <p>
     * 示例:
     * <p>
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1),
                bigDummy = new ListNode(-1), smallPt = smallDummy, bigPt = bigDummy;
        while (head != null) {
            if (head.val < x) {
                smallPt.next = head;
                smallPt = smallPt.next;
            } else {
                bigPt.next = head;
                bigPt = bigPt.next;
            }
            head = head.next;
        }
        bigPt.next = null;
        smallPt.next = bigDummy.next;
        return smallDummy.next;
    }
}
