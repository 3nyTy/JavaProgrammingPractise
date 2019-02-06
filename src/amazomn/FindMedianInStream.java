package amazomn;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {
    PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public int findMedian() {
        if(maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek())/2;
        return maxHeap.peek();
    }

}
