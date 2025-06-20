package blind75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0,right=m-1,top=0,bottom=n-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ls.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ls.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ls.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ls;

    }
}
