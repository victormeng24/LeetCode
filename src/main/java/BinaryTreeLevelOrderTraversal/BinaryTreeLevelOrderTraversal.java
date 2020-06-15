package BinaryTreeLevelOrderTraversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     *  
     * <p>
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int parentSize = 1;
        int childSize = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.get(list.size() - 1).add(node.val);
            if (node.left != null) {
                childSize++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                childSize++;
                queue.offer(node.right);
            }
            parentSize--;
            if (parentSize == 0 && childSize > 0) {
                List<Integer> subList = new ArrayList<>();
                list.add(subList);
                parentSize = childSize;
                childSize = 0;
            }
        }
        return list;
    }
}
