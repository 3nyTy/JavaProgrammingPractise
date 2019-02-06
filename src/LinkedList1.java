
public class LinkedList1 {
	static Node head;
	class Node{

        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
		
	}
	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		for (int i = 20; i > 0; i--) { 
            list.push(i); 
        } 
        System.out.println("Given Linked List :"); 
         list.printList(head); 
        head = list.kAltReverse(head, 3); 
        System.out.println(""); 
        System.out.println("Modified Linked List :"); 
        list.printList(head); 
        
	}
	
	static void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
	 void push(int newdata) { 
        Node mynode = new Node(newdata); 
        mynode.next = head; 
        head = mynode; 
    } 
	
	public static Node kAltReverse(Node head, int k) {
		int count = 0;
		Node curr = head; Node prev = null; Node next = null;
		while(curr!=null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(head != null) {
			head.next = curr;
		}
		int skipCount =0;
		while (skipCount < k-1 && curr!=null) {
			curr = curr.next;
			skipCount++;
		}
		
		if(curr != null) {
			curr.next = kAltReverse(curr.next, k);
		}
		return prev;
		
	}
  
}
