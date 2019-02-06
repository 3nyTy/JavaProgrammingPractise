package amazomn;

import java.util.Random;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};


public class RandomPointerLL {
    
    public static RandomListNode copyList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode ptr = head;
        while(ptr != null) {
            RandomListNode copy = new RandomListNode(ptr.label);
            copy.next = ptr.next;
            ptr.next = copy;
            ptr = copy.next;            
        }
        
        ptr = head;
        
        while (ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
            
        }
        
        //A->A'->B->B'
        
        //split the lists now
        RandomListNode old = head;
        RandomListNode newNode  = head.next; 
        RandomListNode newNodeCopy = head.next;
        while (old != null) {
          old.next = old.next.next;
          newNode.next = newNode.next != null ? newNode.next.next : null;
          old = old.next;
          newNode = newNode.next;
            
        }
        
        
        
        return newNodeCopy;
        
    }
    
    public static void main(String[] args) {
        RandomListNode node  = new RandomListNode(1);
        node.next = new RandomListNode(2);
        node.next.next = new RandomListNode(3);
        node.next.next.next = new RandomListNode(4);
        node.random = node.next.next;
        node.next.random =  node;
        node.next.next.random =  node.next;
        System.out.println("Original List");
        print(node);
        RandomListNode copy = copyList(node);
        System.out.println("Copied List");
        print(copy);
        
    }

    private static void print(RandomListNode node) {
        RandomListNode curr = node;
        while(curr != null) {
            if (curr.random != null) {
            System.out.println("Data is : " + curr.label + " ,Random is : " + curr.random.label);
            }
            curr = curr.next;
        }
    }

}
