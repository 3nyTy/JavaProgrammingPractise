package microsoft;

class LLNode {
    int val;
    LLNode next;

    public LLNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LLReverese {
    public static void main(String[] args) {
        LLNode ll = new LLNode(1);
        ll.next = new LLNode(2);
        ll.next.next = new LLNode(3);
        ll.next.next.next = new LLNode(5);
        ll.next.next.next.next = new LLNode(7);
        ll = reverseLL(ll, 2);
        printList(ll);
    }

    private static void printList(LLNode ll) {
        LLNode curr = ll;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    private static LLNode reverseLL(LLNode ll, int k) {
        if (ll == null)
            return null;
        LLNode curr = ll;
        LLNode prev = null;
        int count = 0;
        LLNode next = null;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            //using ll because 1->2->3->4-> after [erforming above reverse it will be
            //3->2->1->4 where the head is 1 so ll.next should be reverse of next.
            ll.next = reverseLL(next, k);
        }

        return prev;
    }
}
