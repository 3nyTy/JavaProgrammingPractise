package design;

import java.util.LinkedList;
import java.util.Queue;

class Node99{
        int val;
        Node99 left;
        Node99 right;
        Node99(int x) {
            val = x;
        }
}

public class SerializeDeserializeBinTree {
    // Encodes a tree to a single string.
    public static String serialize(Node99 root) {
        if (root == null) return "";
        Queue<Node99> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node99 Node99 = queue.poll();
            if (Node99 == null) {
                res.append(" null");
                continue;
            }
            res.append(" " +Node99.val);
            queue.add(Node99.left);
            queue.add(Node99.right);
        }
        System.out.println(res.toString());
        return res.toString();     
    }

    // Decodes your encoded data to tree.
    public static Node99 deserialize(String data) {
        if (data == null || data.length() <= 0) return null;
        
        Queue<Node99> queue = new LinkedList<>();
        String[] strArray = data.split(" ");
        int count = 0;
        
        Node99 result = new Node99(Integer.parseInt(strArray[0]));
        queue.add(result);
        count++;
        
        while(!queue.isEmpty()) {
           Node99 temp = queue.poll();
           if(!strArray[count].equals(null)) {
               Node99 leftNode = new Node99(Integer.parseInt(strArray[count]));
               temp.left = leftNode;
               queue.add(leftNode);
               
           }
           count++;
           if(!strArray[count].equals(null)) {
               Node99 rightNode = new Node99(Integer.parseInt(strArray[count]));
               temp.right = rightNode;
               queue.add(rightNode);
           }
           
        }
        return result;
    }
        
       public static void main(String[] args) {
        Node99 root = new Node99(20);
        root.left = new Node99(8);
        root.right = new Node99(22);
        root.left.left = new Node99(4);
        root.left.right = new Node99(12);
        String str = SerializeDeserializeBinTree.serialize(root);
        SerializeDeserializeBinTree.deserialize(str);
        
    } 
        
    
}
