import java.util.PriorityQueue;

public class ConnectRopes {
	public static void main(String[] args) {
		
		
	int len[] = {4, 3, 2, 6}; 
    int size = len.length; 
    System.out.println("Total cost for connecting"+ 
                " ropes is " + minCost(len, size));
	}

	private static int minCost(int[] len, int size) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int result = 0;
		
		for (int i=0; i< len.length;i++) {
			pq.add(len[i]);
		}
		
		while(pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			result += first + second;
			
			pq.add(first+second);
		}
		return result;
	}
	

}
