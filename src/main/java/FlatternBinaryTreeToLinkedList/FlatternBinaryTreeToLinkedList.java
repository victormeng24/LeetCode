package FlatternBinaryTreeToLinkedList;

import util.TreeNode;

public class FlatternBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new FlatternBinaryTreeToLinkedList().flatten(root);
        preorder(root);
    }
    /**
     * 给定一个二叉树，原地将它展开为链表。
     * <p>
     * 例如，给定二叉树
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void flatten(TreeNode root) {
        TreeNode pointer = root;
        while (pointer != null) {
            if (pointer.left != null) {
                TreeNode tmp = pointer.right;
                pointer.right = pointer.left;
                pointer.left = null;
                TreeNode s = pointer.right;
                while (s.right != null) {
                    s = s.right;
                }
                s.right = tmp;
            }
            pointer = pointer.right;
        }
    }

    public static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
