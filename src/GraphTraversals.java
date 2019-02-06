import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphTraversals {
	private int V;
	private HashMap<Integer, List<Integer>> adjList;
	public GraphTraversals(int V) {
		this.V = V;
		adjList = new HashMap<Integer, List<Integer>>();
	}
	
public static void main(String[] args) {
	GraphTraversals g = new GraphTraversals(4); 
	  
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 

    System.out.println("Following is Breadth First Traversal "+ 
                       "(starting from vertex 2)"); 
    System.out.println("-------Graph BFS-------");
    g.BFS(2); 
    System.out.println("------------Graph DFS---------");
    g.DFS(2);
}

private void DFS(int i) {
	boolean visitedDFS[] = new boolean[V];
	DFSUtil(i, visitedDFS);
}

private void DFSUtil(int i, boolean[] visitedDFS) {
	visitedDFS[i] = true;
	System.out.println(i+ " ");
	for (int val : adjList.get(i)) {
		if(!visitedDFS[val]) {
			DFSUtil(val, visitedDFS);
		}
	}
	
}
/*Dijkstra(S,G):
    Initialize: Priority queue (PQ), visited HashSet,
                parent HashMap, and distances to infinity.
    Enqueue {S,0} onto the PQ
    while PQ is not empty:
      dequeue node curr from front of queue
      if (curr is not visited)
        add curr to visited set
        if (curr == G) return parent map
        for each of curr's neighbors, n, not in visited set:
          if path through curr to n is shorter
            update curr as n's parent in parent map
            enqueue {n,dist+ance} into the PQ
    //if we get here then there's no path from S to G
*/
private void BFS(int s) {
	boolean visited[] = new boolean[V];
	LinkedList<Integer> queue = new LinkedList<Integer>();
	visited[s] = true;
	queue.add(s);
	while(queue.size()!=0) {
		s = queue.poll();
		System.out.println(s+ " ");
		for(int i : adjList.get(s)) {
			if(!visited[i]) {
				visited[i] = true;
				queue.add(i);
			}
			
		}
		
	}
	
}

private void addEdge(int v, int w) {
	List<Integer> list = null;
	if(adjList.containsKey(v)) {
		list = adjList.get(v);
		list.add(w);
		adjList.put(v, list);
	} else {
		list = new ArrayList<Integer>();
		list.add(w);
		adjList.put(v, list);
	}
	
}
}
