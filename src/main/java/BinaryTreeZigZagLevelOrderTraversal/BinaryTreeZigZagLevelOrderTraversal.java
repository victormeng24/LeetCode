package BinaryTreeZigZagLevelOrderTraversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {
    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回锯齿形层次遍历如下：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        traverse(result, 0, root);
        return result;
    }

    public void traverse(List<List<Integer>> result, int depth, TreeNode node) {
        if (depth == result.size()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        if (depth % 2 == 1) {
            result.get(depth).add(0, node.val);
        } else {
            result.get(depth).add(node.val);
        }
        if (node.left != null) {
            traverse(result, depth + 1, node.left);
        }
        if (node.right != null) {
            traverse(result, depth + 1, node.right);
        }
    }
}
