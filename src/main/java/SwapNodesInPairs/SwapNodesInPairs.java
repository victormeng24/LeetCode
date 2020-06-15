package SwapNodesInPairs;

import util.ListNode;
import util.ListUtil;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{1, 2, 3});
        ListNode res = new SwapNodesInPairs().swapPairs(head);
        ListUtil.printList(res);
    }
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode nxt = head.next;
        ListNode tmp = head.next.next;
        nxt.next = pre;
        pre.next = swapPairs(tmp);
        return nxt;
    }
}
