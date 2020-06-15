package MergeKSortedLists;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            pointer.next = tmp;
            if (tmp.next != null) {
                queue.offer(tmp.next);
            }
            pointer = pointer.next;
        }
        return dummy.next;
    }
}
