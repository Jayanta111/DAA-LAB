public class MazeSolver {
    static int[][] maze = {
        {1, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 1, 1},
        {1, 0, 0, 1}
    };

    static int n = maze.length;
    static int m = maze[0].length;
    static boolean[][] visited = new boolean[n][m];

    static boolean dfs(int x, int y, int goalX, int goalY) {
        if (x < 0 || y < 0 || x >= n || y >= m || maze[x][y] == 0 || visited[x][y])
            return false;

        if (x == goalX && y == goalY)
            return true;

        visited[x][y] = true;

        // Move in 4 directions: down, up, right, left
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int dir = 0; dir < 4; dir++) {
            if (dfs(x + dx[dir], y + dy[dir], goalX, goalY))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int startX = 0, startY = 0;
        int goalX = 3, goalY = 3;

        boolean pathExists = dfs(startX, startY, goalX, goalY);

        System.out.println("Path exists: " + pathExists);
    }
}
