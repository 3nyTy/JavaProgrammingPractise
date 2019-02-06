package LinkedLists;

import java.util.LinkedList;

public class LLPartition {
public static void main(String[] args) {
    int[] vals = {33,9,2,3,10,10389,838,874578,5};
    LinkedListNode head = new LinkedListNode(vals[0], null, null);
    LinkedListNode current = head;
    for (int i = 1; i < vals.length; i++) {
        current = new LinkedListNode(vals[i], null, current);
    }
    
    System.out.println(head.printForward());
    
    LinkedListNode h = partition(head,3);
    
    System.out.println(h.printForward());
}

private static LinkedListNode partition(LinkedListNode head, int x) {
    LinkedListNode smallHead = new LinkedListNode(0);
    LinkedListNode smallCurr = smallHead;
    LinkedListNode largeHead = new LinkedListNode(0);
    LinkedListNode largeCurr = largeHead;
    
    while(head != null) {
       if(head.data < x) {
           smallCurr.next = head;
           smallCurr = smallCurr.next;
       } else {
           largeCurr.next = head;
           largeCurr = largeCurr.next;
       }
           head= head.next;
       }
    largeCurr.next = null;
    smallCurr.next = largeHead.next;
    return smallHead.next;
}
}
    