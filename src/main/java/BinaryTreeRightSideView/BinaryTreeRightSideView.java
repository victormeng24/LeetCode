package BinaryTreeRightSideView;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode root, int depth) {
        if(root == null) return;
        if(list.size() == depth) {
            list.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
