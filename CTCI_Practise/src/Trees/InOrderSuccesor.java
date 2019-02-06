package Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**********     //5 6 4 7 8 10 12 14
 *      10      //InordeSucc for 6 -> 4 
 *      / \     //InordeSucc for 8 ->10
 *     6    14  //InOrder for 5 -> 6
 *    /\    /
 *   5  7  12
 *     /\
 *    4  8
 * ***********/
public class InOrderSuccesor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = find(root, p);

        // Case 1 :

        if (curr == null)
            return null;

        // Case 2 :

        if (curr.right != null) {
            return findMin(curr.right);
        }

        // Case 3 :
        else {
            TreeNode succesor = null;
            TreeNode ancestor = root;
            while (ancestor != curr) {
                if (curr.val < ancestor.val) {
                    succesor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }

            return succesor;
        }
    }

    public TreeNode findMin(TreeNode curr) {
        TreeNode temp = curr;
        if (curr == null)
            return null;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public TreeNode find(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        else if (root.val == p.val)
            return root;
        else if (root.val < p.val)
            return find(root.right, p);
        return find(root.left, p);
    }

}
