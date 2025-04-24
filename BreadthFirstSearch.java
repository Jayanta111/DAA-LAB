import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;


public class BreadthFirstSearch {

    // Represents a graph using an adjacency list
    private static List<List<Integer>> graph;

    public static void bfs(int startNode) {
        int n = graph.size(); // Number of nodes in the graph
        boolean[] visited = new boolean[n]; //Keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); //Use a queue for BFS

        visited[startNode] = true;
        queue.offer(startNode); // Add the start node to the queue

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // Remove the next node from the queue
            System.out.print(currentNode + " "); // Process the node (here, just print it)

            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Example Graph:  Adjacency list representation
        int numNodes = 7;
        graph = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        //Add edges (undirected graph - add edges in both directions)
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 5);
        addEdge(2, 6);


        System.out.println("BFS traversal starting from node 0:");
        bfs(0); //Start BFS from node 0

        System.out.println("\nBFS traversal starting from node 2:");
        bfs(2);  //Start BFS from node 2
    }

    //Helper function to add an undirected edge between two nodes
    private static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}