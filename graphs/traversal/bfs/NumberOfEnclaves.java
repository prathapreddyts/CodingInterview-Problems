package graphs.traversal.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public int numberOfEnclaves(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        // Add all boundary 1s to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = 1;
                    }
                }
            }
        }

        // BFS to mark all reachable 1s from boundary
        while (!queue.isEmpty()) {
            int[] polledNode = queue.poll();
            for (int[] direction : directions) {
                int r = direction[0] + polledNode[0];
                int c = direction[1] + polledNode[1];
                if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1 && visited[r][c] == 0) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = 1;
                }
            }
        }

        // Count all 1s not visited (enclaves)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
