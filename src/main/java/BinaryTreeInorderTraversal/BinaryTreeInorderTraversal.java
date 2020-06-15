package BinaryTreeInorderTraversal;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            curr = tmp.right;
        }
        return result;
    }
}
