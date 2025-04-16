package graphs.traversal.bfs;

import java.util.*;

public class NearestZeroValueOne {
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dis = new int[m][n];

        Queue<Node> q = new LinkedList<Node>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;

                } else {
                    vis[i][j] = false;
                }
            }
        }
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.first;
            int c = curr.second;
            int s = curr.third;
            dis[r][c] = s;
            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false) {
                    vis[nr][nc] = true;
                    q.add(new Node(nr, nc, s + 1));
                }
            }
        }
        return dis;

    }
}

class Node {
    int first;
    int second;
    int third;

    Node(int f, int s, int t) {
        this.first = f;
        this.second = s;
        this.third = t;
    }
}
