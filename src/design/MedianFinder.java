package design;

import java.util.*;

public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<Integer>();
        maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() > o2.intValue())
                    return -1;
                if (o1.intValue() < o2.intValue())
                    return 1;
                return 0;
            }
        });

    }

    public void addNum(int num) {
        if (minH.size() == 0 && maxH.size() == 0)
            minH.add(num);
        else if (minH.size() > maxH.size()) {
            if (num > minH.peek()) {
                maxH.add(minH.poll());
                minH.add(num);
            } else {
                maxH.add(num);
            }
        } else if (maxH.size() > minH.size()) {
            if (num < maxH.peek()) {
                minH.add(maxH.poll());
                maxH.add(num);
            } else {
                minH.add(num);
            }
        } else {
            if (num < maxH.peek()) {
                maxH.add(num);
            } else {
                minH.add(num);
            }
        }

    }

    public double findMedian() {
        if (minH.size() == 0 && maxH.size() == 0)
            return 0.0;
        if (minH.size() > maxH.size())
            return (double) minH.peek();
        if (maxH.size() > minH.size())
            return (double) maxH.peek();
        return (double) ((minH.peek() + maxH.peek()) / 2.0);

    }

}
