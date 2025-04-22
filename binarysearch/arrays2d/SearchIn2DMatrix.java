package binarysearch.arrays2d;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrixUsingBinarySearch(matrix, target);
    }

    public static boolean searchInMatrixUsingBinarySearch(int[][] matrix, int target) {
        boolean istargetFound=false;
        int colStart=0;
        int colEnd=matrix[0].length-1;
        int rowStart=0;
        int rowEnd=matrix.length-1;

        while(rowStart+1<rowEnd){
            int rowMid=rowStart+(rowEnd-rowStart)/2;
            int colMid=colStart+(colEnd-colStart)/2;
            int value=matrix[rowMid][colMid];
            if(value==target){
                istargetFound=true;
            }else if(value<target){
                rowStart=rowMid;
            }else{
                rowEnd=rowMid;
            }
        }
        return istargetFound;

    }


    /*
     *
     * Simple mat calculation is there
     * Asuming the 2D matrix is store in the array and value will be calulated
     * row=mid/col.length
     * col=mid%col.length
     *
     * */
    public static boolean searchInMatrixUsingBinarySearchOptimised(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int rowIdx = mid / col;
            int colIdx = mid % col;
            int matrixEle = matrix[rowIdx][colIdx];
            if (matrixEle == target) {
                return true;
            } else if (matrixEle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchInMatrixUsingBinarySearchImproved(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][col]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean searchMatrixUsingBinarySearch(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixBrute(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }


}
