package DiameterOfBinaryTree;

import util.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
    int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        tarverse(root);
        return maxLen;
    }

    public int tarverse(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = tarverse(root.left);
        int maxRight = tarverse(root.right);
        maxLen = Math.max(maxLen, maxLeft + maxRight);
        return Math.max(1 + maxLeft, 1 + maxRight);
    }
}
