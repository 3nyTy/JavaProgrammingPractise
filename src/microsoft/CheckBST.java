package microsoft;

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class CheckBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(10);
        tree.right = new TreeNode(30);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(40);
        System.out.println(isValidBST(new TreeNode(0)));

    }

    private static boolean isValidBST(TreeNode tree) {
        int min_val = Integer.MIN_VALUE;
        int max_val = Integer.MAX_VALUE;
        
        
        return binaryUtil(tree, min_val, max_val);
    }

    private static boolean binaryUtil(TreeNode tree, int min_val, int max_val) {
        if(tree == null) return true;
        
        return (tree.val > min_val && tree.val < max_val) && binaryUtil(tree.left, min_val, tree.val) && binaryUtil(tree.right, tree.val, max_val);
    }
}
