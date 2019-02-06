package design;

import java.util.Stack;

public class MinStackUsingLL {
    class Node{
        int val;
        Node next;
        Node oldMin;
    }

   Node stack;
   Node min;

    public void push(int x) {
        Node n = new Node();
        n.val = x;
        if (stack == null) {
            stack = n;
        } else {
            n.next = stack;
            stack = n;
        }
        
        if (x < min.val) {
            n.oldMin = min;
            min.val = x;                   
            
        }
        
    }

    public void pop() {
        Node n = stack;
        stack = n.next;
        if (n.oldMin !=null) min = n.oldMin;
    }

    public int top() {
        return stack.val;

    }

    public int getMin() {
        return min.val;
    }



}
