package LinkedLists;

import java.util.HashSet;
import java.util.Set;

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class RemoveDup {
    
    public static void main(String[] args) {
        Node one = new Node(1);
        one.next = new Node(2);
        one.next.next = new Node(1);
        one.next.next.next = new Node(3);
        //one = removeDuplicatesFromList(one);
        one =  removeWithoutSet(one);
        printList(one);
    }

    private static Node removeWithoutSet(Node head) {
        Node curr = head;
        while(curr != null) {
            Node ptr = curr;
            System.out.println(curr.val);
            while(ptr.next != null) {
                System.out.println(ptr.val);
                if(ptr.next.val == curr.val) {
                    ptr.next = ptr.next.next;
                    
                } else {
                    System.out.println("Before:" + ptr.val);
                    ptr = ptr.next;
                    System.out.println("After :" + ptr.val);
                }
                
            }
            curr = curr.next;
        }
        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    private static Node removeDuplicatesFromList(Node one) {
        Node curr = one;
        Set<Integer> hset = new HashSet<>();
        Node prev = null;
        while(curr != null) {
            if(hset.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                hset.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return one;
    }

}
