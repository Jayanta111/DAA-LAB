import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsMST {

    public static List<Edge> findMST(List<Edge> edges, int numVertices) {
        Collections.sort(edges); // Sort edges by weight
        DisjointSet disjointSet = new DisjointSet(numVertices);
        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            if (disjointSet.find(edge.source) != disjointSet.find(edge.destination)) {
                mst.add(edge);
                disjointSet.union(edge.source, edge.destination);
                mstWeight += edge.weight;
            }
        }

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mst) {
            System.out.println("(" + edge.source + ", " + edge.destination + ") : " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 9));
        edges.add(new Edge(1, 4, 7));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(3, 4, 15));
        edges.add(new Edge(3, 5, 6));
        edges.add(new Edge(4, 5, 8));
        edges.add(new Edge(4, 6, 9));
        edges.add(new Edge(5, 6, 11));

        int numVertices = 7; // Number of vertices in the graph
        findMST(edges, numVertices);
    }
}

// Edge class to represent a graph edge
class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// DisjointSet class for union-find operations
class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}
