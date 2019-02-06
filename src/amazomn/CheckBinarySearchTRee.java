package amazomn;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

public class CheckBinarySearchTRee {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isBSTUtil(root, min, max);
    }
    public boolean isBSTUtil(TreeNode root, long min, long max) {
        if (root == null) return true;

        return (root.val > min && root.val < max && isBSTUtil(root.left, min, root.val) &&
               isBSTUtil(root.right, root.val, max));
    }
}
