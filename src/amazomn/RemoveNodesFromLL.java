package amazomn;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class RemoveNodesFromLL {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        
        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(2);
        
        ListNode node4 = new ListNode(5);
        node4.next = new ListNode(5);
        node4.next.next = new ListNode(5);
            
        ListNode node5 = new ListNode(1);
        node4.next = new ListNode(2);
        node4.next.next = new ListNode(5);
        node4.next.next.next = new ListNode(5);
        
        ListNode node6 = new ListNode(1);
        node4.next = new ListNode(2);
        node4.next.next = new ListNode(5);
        node4.next.next.next = new ListNode(5);
        node4.next.next.next = new ListNode(3);
        
       /* System.out.println("Beforeeeee........");
        printList(node2);

        node2 = removeNode(node2, 5);
        
        System.out.println("After.......");      
        printList(node2);*/
   
        System.out.println("Beforeeeee........");
        
        printList(node6);

        node6 = removeNode(node6, 5);
        
        System.out.println("After.......");      
        printList(node6);
    }

    private static void printList(ListNode node) {
        ListNode current = node;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static ListNode removeNode(ListNode head, int val) {
        ListNode previous = null;
        ListNode curr = head; 
        
        while(curr != null) {
            if (curr.data == val) {
                if (curr == head) {
                    head = curr.next;
                } else {
                    previous.next = curr.next;
                }
            } else {
                previous = curr;
            }
            curr = curr.next;
        }
        
        /*while(curr != null) {
            if (curr.data == val) {
                if (curr == head) {
                    head = curr.next;
                } else {
                    previous.next = curr.next;    
                }
            } else {
                previous = curr;
            }
           curr = curr.next; 
        }*/
        return head;
    }   

}
