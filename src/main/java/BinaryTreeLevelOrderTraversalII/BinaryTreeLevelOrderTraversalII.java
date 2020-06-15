package BinaryTreeLevelOrderTraversalII;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * <p>
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        traversal(list, 1, root);
        return list;
    }

    public void traversal(List<List<Integer>> list, int depth, TreeNode node) {
        if (depth > list.size()) {
            List<Integer> subList = new ArrayList<>();
            list.add(0, subList);
        }
        list.get(list.size() - depth).add(node.val);
        if (node.left != null) {
            traversal(list, depth + 1, node.left);
        }
        if (node.right != null) {
            traversal(list, depth + 1, node.right);
        }
    }
}