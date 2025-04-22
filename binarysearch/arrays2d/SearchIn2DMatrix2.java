package binarysearch.arrays2d;

public class SearchIn2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
