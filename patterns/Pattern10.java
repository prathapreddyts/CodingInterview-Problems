package patterns;

public class Pattern10 {

    public void pattern10(int n) {
        int rows=2*n-1;
        for(int i=0;i<rows;i++){
            if(i<n){
                for(int j=0;j<=i;j++){
                    System.out.print("*");
                }
            }else{
                for(int k=n-1;k>i-n;k--){
                    System.out.print("*");
                }
            }

            System.out.println();
        }

    }
}
