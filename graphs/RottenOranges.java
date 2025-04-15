package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        int freshOranges = 0;
        int totalTimeTakeRotten = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        while (!queue.isEmpty())
        {
            int size = queue.size();
            boolean rottenNow = false;
            for (int i = 0; i < size; i++) {
                int[] pollVertex = queue.poll();
                for (int[] direction : directions) {
                    int r = direction[0] + pollVertex[0];
                    int c = direction[1] + pollVertex[1];
                    if (r >= 0 && c >= 0 && r < row && c < col && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new int[]{r, c});
                        freshOranges--;
                        rottenNow = true;
                    }
                }
            }
            if (rottenNow) {
                totalTimeTakeRotten++;
            }
        }

        return freshOranges == 0 ? totalTimeTakeRotten : -1;
    }
}
