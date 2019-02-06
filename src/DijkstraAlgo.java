import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Node implements Comparator<Node> {
    int node, cost;

    public Node() {
    };

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int compare(Node o1, Node o2) {
        return o1.cost - o2.cost;
    }
}

/*
 * Dijkstra(S,G):
 * Initialize: Priority queue (PQ), visited HashSet,
 * parent HashMap, and distances to infinity.
 * Enqueue {S,0} onto the PQ
 * while PQ is not empty:
 * dequeue node curr from front of queue
 * if (curr is not visited)
 * add curr to visited set
 * if (curr == G) return parent map
 * for each of curr's neighbors, n, not in visited set:
 * if path through curr to n is shorter
 * update curr as n's parent in parent map
 * enqueue {n,dist+ance} into the PQ
 * //if we get here then there's no path from S to G
 */

public class DijkstraAlgo {
    private int[] dist;
    private Set<Integer> visited;
    private PriorityQueue<Node> pq;
    private int V;
    List<List<Node>> adj;

    public DijkstraAlgo(int V) {
        this.V = V;
        dist = new int[V];
        visited = new HashSet<>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int source) {
        this.adj = adj;
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(source, 0));

        dist[0] = 0;
        while (visited.size() != V) {

            int top = pq.remove().node;

            visited.add(top);

            checkNeighbours(top);

        }

    }

    private void checkNeighbours(int top) {
        
        int edgeDistance = -1;
        int newDistance = -1;
        
        for(int i = 0; i < adj.get(top).size(); i++) {
            Node curr = adj.get(top).get(i);
            
            if (!visited.contains(curr)) {
                edgeDistance = curr.cost;
                newDistance = dist[top] + edgeDistance;
                
                if (newDistance < dist[curr.node]) {
                    System.out.println("BeforeDistance at " + curr.node + " : " + dist[curr.node]);
                    dist[curr.node] = newDistance;
                    System.out.println("AfterDistance at " + curr.node + " : " + dist[curr.node]);

                }
                
                pq.add(new Node(curr.node, dist[curr.node]));
                
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;
        List<List<Node>> adj = new ArrayList<List<Node>>();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        DijkstraAlgo dpq = new DijkstraAlgo(V);
        dpq.dijkstra(adj, source);

        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is " + dpq.dist[i]);

    }

}
