package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTreeTraversal {
public static void main(String[] args) {
    
}

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) return null;
    TreeNode curr = null;
    //LinkedList<TreeNode> queue  = new LinkedList<>();
    List<List<Integer>> out = new ArrayList<List<Integer>>();
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    s1.push(root);
    while(!s1.isEmpty() || !s2.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        while(!s1.isEmpty()) {
            curr = s1.pop();
            tmp.add(curr.val);
            if(curr.left != null) {
                s2.push(curr.left);
            }
            if(curr.right != null) {
                s2.push(curr.right);
            }
        }
            out.add(tmp);
            tmp = new ArrayList<>();
            while(!s2.isEmpty()) {
                curr = s2.pop();
                tmp.add(curr.val);
                if(curr.right != null) {
                    s1.push(curr.right);
                }
                if(curr.left != null) {
                    s1.push(curr.left);
                }
            }
            
            if(!tmp.isEmpty()) out.add(tmp);
            
        }
            
return out;    }
}

    
    
    
    /*queue.offer(root);
    queue.offer(null);
    int level = 0;
    while(queue.size() > 0) {
        TreeNode temp = queue.poll();
        Stack<TreeNode> st = null;
        if(temp != null) {
            st = new Stack<>(); 
            if(temp.left != null) {
                queue.add(temp.left);
                if(level % 2 != 0) {
                    st.push(temp.left);
                }

            } else if(temp.right != null) {
                queue.add(temp.right);
                if(level % 2 !=0 ) {
                    st.push(temp.right);
            }
                
            }
        } else {
            ArrayList<Integer> arr = new ArrayList<>();
            while(!st.isEmpty()) {
                arr.add(st.pop().val);
            }
            out.add(arr);
            level++;
        }
        
    }
    */

