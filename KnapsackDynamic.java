public class KnapsackDynamic {

    public static int knapsack(int n, int W, int[] weights, int[] values) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int n = 3;
        int W = 5;
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};

        int maxValue = knapsack(n, W, weights, values);
        System.out.println("Maximum value: " + maxValue); 

        //Illustrative DP table (partial)
        System.out.println("\nPartial DP Table:");
        System.out.print("      ");
        for(int w=0; w<=W; w++) System.out.print(w + "  ");
        System.out.println();
        for(int i=0; i<=n; i++){
            System.out.print((i==0 ? " " : i) + "  ");
            for(int w=0; w<=W; w++){
                System.out.print(String.format("%-2d", knapsack(i,w,weights,values)) + " ");
            }
            System.out.println();
        }
    }
}