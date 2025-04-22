package binarysearch.arrays2d;

public class RowWithMax1s {
    /*
    * Started from top right and moved towards left and then moved to next row
    *
    * */
    public int rowWithMax1s(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxRowIndex = -1;

        int j = m - 1; // Start from top-right corner

        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] == 1) {
                j--;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

}
