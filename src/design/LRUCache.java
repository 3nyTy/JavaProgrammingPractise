package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DoublyLinkedList {
    Node last, first;

    public void addLast(Node node) {
        if (first == null) {
            first = node;
            last = first;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }

    public void removeAndAddLast(Node node) {
        if (last.value == node.value) {
            return;
        }
        if (first.value == node.value) {
            Node temp = first;
            first = first.next;
            temp.next = null;
            addLast(temp);
            return;
        }
        Node previous = node.prev;
        Node forward = node.next;

        previous.next = forward;
        forward.prev = previous;
        node.next = null;
        node.prev = null;

        addLast(node);

    }

    public Node removeFirst() {
        if (first == null) {
            return null;
        }
        Node temp = first.next;
        temp.next = null;
        return temp;
    }

    public int size() {
        return this.size();
    }

}

class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;

    }
}

public class LRUCache {

    static final Map<Integer, Node> cache = new HashMap<>();
    static final DoublyLinkedList recentlyQueried = new DoublyLinkedList();
    static int capacity = 0;
    static int size = 0;

    // static double loadFactor = 0.6;
    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }

        if (this.size >= this.capacity) {
            Node removedNode = recentlyQueried.removeFirst();
            cache.remove(removedNode.value);
            this.size--;
        }
        Node node = new Node(value);
        cache.put(key, new Node(value));
        recentlyQueried.addLast(node);
        this.size++;

    }

    public int get(int key) {
        int result = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            recentlyQueried.removeAndAddLast(node);
            cache.remove(key);
            result = node.value;
            cache.put(key, node);
        }
        return result;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        Map<Integer, Node> hm = lruCache.cache;

        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(2));
        for (Entry<Integer, Node> entry : hm.entrySet()) {
            System.out.println("Key is : " + entry.getKey() + " , Value is : " + entry.getValue().value);
        }
    }

}
