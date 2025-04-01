package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_Diagonal_Include {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Up, Down, Left, Right
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonal movements
        };

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '2'; // Mark as visited

                    while (!queue.isEmpty()) {
                        int[] polledNode = queue.poll();
                        for (int[] direction : directions) {
                            int r = direction[0] + polledNode[0];
                            int c = direction[1] + polledNode[1];
                            if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == '1') {
                                queue.add(new int[]{r, c});
                                grid[r][c] = '2'; // Mark as visited
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
