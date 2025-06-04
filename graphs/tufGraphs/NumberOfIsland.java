package graphs.tufGraphs;

import java.util.Stack;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        if (grid == null || grid.length == 0) {
            return numberOfIslands;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Up, Down, Left, Right
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonals
        };

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands++;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{row, col});

                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        int curRow = current[0];
                        int curCol = current[1];
                        grid[curRow][curCol] = '0'; // Mark visited

                        for (int[] dir : directions) {
                            int newRow = curRow + dir[0];
                            int newCol = curCol + dir[1];
                            if (newRow >= 0 && newRow < rows &&
                                    newCol >= 0 && newCol < cols &&
                                    grid[newRow][newCol] == '1') {
                                stack.push(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return numberOfIslands;
    }


}
