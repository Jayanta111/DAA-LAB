 import java.util.*;

public class ConnectedComponentsBFS {

    static void bfs(int start, boolean[] visited, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;  // number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(5);
        adj.get(5).add(4);

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i, visited, adj);
                count++;
            }
        }

        System.out.println("Number of connected components: " + count);
    }
}
 