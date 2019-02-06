
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class HeapOperations {

    public static void main(String[] args) {
        int[] heap = new int[16];
        int last = 1;
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int q=0; q < queries; q++) {
            int op = in.nextInt();
            switch(op) {
                case 1:
                	 int value = in.nextInt();
                     if (last == heap.length) {
                       heap = doubleSizeOf(heap);
                     }
                     heap[last] = value;
                     swim(heap, last);
                     last++;
                     break;
               // heap[last] = value;
                // always keeps minimum at top
                //sink(heap, last);
               // last++;
                //insertToHeap(heap, last, value);
                //printHeap(heap);
               // break;
                case 2:
                value = in.nextInt();
                int posToDelete = findInHeap(heap, value, last);
                last--;
                swap(heap, posToDelete, last);
                //restore heap property after deletion
                sink(heap, posToDelete, last);
                //heapify(heap, posToDelete);
                break;
                case 3:
                if(last >= 0) {
                    System.out.println(heap[0]);
                }
                break;
            
                default: ;
            }
        }
        in.close();
        }

	/*private static void insertToHeap(int[] heap, int last, int val) {
		int i = last -1;
		while(i >=0 && val < heap[(i-1)/2] ) {
			heap[i] = heap[(i-1)/2];
			i = (i-1)/2;
		}
		heap[i] = val;
		
	}
*/
	private static void printHeap(int[] heap) {
		System.out.println("Elements in heap");
		for(int i=0;i<heap.length;i++) {
			System.out.println(heap[i]);
		}
	}

	private static int[] doubleSizeOf(int[] heap) {
		int[] newArr = new int[heap.length * 2];
		for (int i=0; i < heap.length; i++) {
			newArr[i] = heap[i];
		}
		return newArr;
	}

	private static void sink(int[] heap, int pos, int last) {
		int left = pos*2;
	    int right = pos*2+1;
	    int posToSwap = pos;
	    if (left<last && heap[left]<heap[posToSwap]) {
	      posToSwap = left;
	    }
	    if (right<last && heap[right]<heap[posToSwap]) {
	      posToSwap = right;
	    }
	    if (pos == posToSwap) {
	      return;
	    }
	    swap(heap, pos, posToSwap);
	    sink(heap, posToSwap, last);
	}

	private static void swap(int[] heap, int from, int to) {
		int temp = heap[from];
		heap[from] = heap[to];
		heap[to] = heap[from]; 
	}

	private static int findInHeap(int[] heap, int key, int last) {
		return findInHeapPosition(heap, key, last, 1);
	}

	private static int findInHeapPosition(int[] heap, int key, int last, int pos) {
		if(last <= pos) {
			return -1;
		}
		if(heap[pos] == key) return pos;
		int foundInLeft = findInHeapPosition(heap, key, last, (2*pos)+1);
		if(foundInLeft > -1) return foundInLeft;
		return findInHeapPosition(heap, key, last, (2*pos)+2);		
		
	}

	private static void swim(int[] heap, int pos) {
		int parent = pos/2;
	    while (parent>0 && heap[pos]<heap[parent]) {
	      swap(heap, parent, pos);
	      pos = parent;
	      parent = pos/2;
	    }
		
	}
    
        

      
}


