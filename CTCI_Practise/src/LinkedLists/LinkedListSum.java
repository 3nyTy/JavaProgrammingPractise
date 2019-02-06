package LinkedLists;

public class LinkedListSum {
    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
        
        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);  
        
        LinkedListNode list3 = addLists(lA1, lB1);
        System.out.println("  " + lA1.printForward());      
        System.out.println("+ " + lB1.printForward());          
        System.out.println("= " + list3.printForward());    
        
        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);
        
        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));  
    }

    private static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;     
    }

    private static LinkedListNode addLists(LinkedListNode lA1, LinkedListNode lB1) {
        if (lA1 == null) return lB1;
        if(lB1 == null) return lA1;
        int length1 = getLength(lA1);
        int length2 = getLength(lB1);
        
        if(length1 > length2) {
            lB1 = padList(lB1, length1 - length2);
        } else {
            lA1 = padList(lA1, length2 - length1);
        }
        
        return addLists(lA1, lB1, 0);
    }

    private static LinkedListNode padList(LinkedListNode node, int padCount) {
        LinkedListNode curr = node;
        for(int i = 0; i < padCount; i++) {
            curr = insertBefore(curr, 0);
        }
        
        return curr;
    }

    private static LinkedListNode insertBefore(LinkedListNode curr, int val) {
        LinkedListNode zero = new LinkedListNode(val);
        if (curr != null) {
            zero.next = curr;
        }
        return zero;
    }

    private static int getLength(LinkedListNode lA1) {
        int count = 0;
        LinkedListNode curr = lA1;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        LinkedListNode result = new LinkedListNode(0);
        LinkedListNode p1 = l1; LinkedListNode p2 = l2; LinkedListNode curr = result;
        while(p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.data : 0;
            int y = (p2 != null) ? p2.data: 0;
            int sum = x + y + carry;
            carry = sum /10;
            curr.next = new LinkedListNode(sum % 10);
            curr = curr.next;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        } 
        if (carry > 0) {
            curr.next = new LinkedListNode(carry);
        }
        return result.next;
    }

}
