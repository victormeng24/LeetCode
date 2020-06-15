package InsertionSortList;

import util.ListNode;

public class InsertionSortList {
    /**
     * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     * <p>
     *  
     * <p>
     * 插入排序算法：
     * <p>
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2：
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insertion-sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 如果是升序，则遍历下一个
            if (end.val < cur.val) {
                end.next = cur;
                end = cur;
                cur = cur.next;
            } else {
                // 先定义一个 tmp 指向 cur 下一个结点防止丢链
                ListNode tmp = cur.next;
                // 断开要排的元素
                end.next = tmp;
                // 从头判断找出合适的插入位置
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                // 找到插入位置后直接将元素放进来
                cur.next = pre.next;
                pre.next = cur;
                // 随后将定位指针归为
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }
}
