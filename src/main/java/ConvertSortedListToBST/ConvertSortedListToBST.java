package ConvertSortedListToBST;

import util.ListNode;
import util.ListUtil;
import util.TreeNode;

public class ConvertSortedListToBST {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildListByArray(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = new ConvertSortedListToBST().sortedListToBST(head);
        System.out.println(root.val);
    }
    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if(head == mid) return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }


    private ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) {
            prev.next = null;
        }
        return slow;
    }

}
