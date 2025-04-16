package graphs.traversal.bfs;

import java.util.*;

class DistinctIslandsBFS {
    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<String> uniqueIslands = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    bfs(grid, visited, i, j, shape);
                    uniqueIslands.add(String.join(",", shape));
                }
            }
        }
        return uniqueIslands.size();
    }

    private void bfs(int[][] grid, boolean[][] visited, int row, int col, List<String> shape) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int baseRow = row, baseCol = col;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            shape.add((r - baseRow) + "_" + (c - baseCol)); // Store relative position

            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (isValid(grid, visited, newRow, newCol)) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private boolean isValid(int[][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited[r][c] && grid[r][c] == 1;
    }
}

