import java.util.Arrays;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n]; // Shortest distance from source to each node
        boolean[] visited = new boolean[n]; // Tracks visited nodes

        // Initialize distances to infinity except for the source
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited); // Corrected method name

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                // Update distances only if:
                // 1. There's an edge between u and v.
                // 2. The node v hasn't been visited.
                // 3. The distance through u is shorter than the current distance to v.
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, source);
    }

    // Finds the vertex with the minimum distance value, from the set of vertices not yet visited
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Prints the solution
    private static void printSolution(int[] dist, int source) {
        System.out.println("Vertex\tDistance from Source " + source);
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE},
            {4, 0, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 11, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 8, 0, 7, Integer.MAX_VALUE, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 0, 9, 14, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 14, 10, 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 0, 1, 6},
            {8, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 7},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}
