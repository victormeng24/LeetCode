package BinaryTreePreorderTraversal;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     * <p>
     *  示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return result;
    }
}
