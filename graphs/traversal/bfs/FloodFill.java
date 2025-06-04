package graphs.traversal.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int orgColor = image[sr][sc];

        if (orgColor == newColor){
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor; // Mark starting pixel

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && image[r][c] == orgColor) {
                    image[r][c] = newColor; // Mark as visited
                    queue.add(new int[]{r, c});
                }
            }
        }
        return image;
    }
}
