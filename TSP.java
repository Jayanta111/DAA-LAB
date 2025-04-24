import java.util.Scanner;

public class TSP {
    static int[][] dist;
    static int[][] dp;
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static int tsp(int mask, int pos) {
        if (mask == (1 << n) - 1) {
            return dist[pos][0]; // Return to starting city
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int minCost = INF;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }

        return dp[mask][pos] = minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        dist = new int[n][n];
        dp = new int[1 << n][n];

        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        // Initialize DP table
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int result = tsp(1, 0); // Start at city 0
        System.out.println("Minimum TSP cost: " + result);
        sc.close();
    }
}


