package blind75;

public class RotateImage {
    public  void rotate(int[][] matrix) {
        swapUpperLowerTriangle(matrix);
        for (int[] row : matrix) {
            reverseRow(row);
        }
    }
    public  void swapUpperLowerTriangle(int[][] matrix) {
        int len = matrix.length;
        for (int row = 0; row < len; row++) {
            for (int col = row + 1; col < len; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }


    public  void reverseRow(int[] row) {
        int start = 0;
        int end = row.length-1;
        while (start < end) {
            int temp = row[start];
            row[start]=row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}
