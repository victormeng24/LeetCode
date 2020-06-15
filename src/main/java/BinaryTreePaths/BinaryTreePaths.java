package BinaryTreePaths;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * <p>
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) return list;
        traversal(list, root, "");
        return list;
    }

    public void traversal(List<String> list, TreeNode root, String prePath) {
        if (root.left == null && root.right == null) {
            prePath += Integer.toString(root.val);
            list.add(prePath);
            return;
        }
        if (root.left != null) {
            traversal(list, root.left, prePath + root.val + "->");
        }
        if (root.right != null) {
            traversal(list, root.right, prePath + root.val + "->");
        }
    }
}
