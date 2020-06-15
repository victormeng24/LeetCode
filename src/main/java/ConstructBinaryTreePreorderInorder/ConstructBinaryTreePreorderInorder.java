package ConstructBinaryTreePreorderInorder;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode root = new ConstructBinaryTreePreorderInorder().buildTree(pre, in);
        System.out.println(root.left.val);
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 通过次数57,812提交次数89,150
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private int[] preorder;
    private int[] inorder;
    private int index;
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(0, preorder.length - 1);
    }

    public TreeNode buildHelper(int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index]);
        index++;
        root.left = buildHelper(start, mid - 1);
        root.right = buildHelper(mid + 1, end);
        return root;
    }
}
