package SymmetricTree;

import util.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareTree(root.left, root.right);
    }

    public boolean compareTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return compareTree(t1.right, t2.left) && compareTree(t1.left, t2.right);
    }
}
