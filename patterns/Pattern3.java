package patterns;

public class Pattern3 {
    public static void main(String[] args) {

    }
    public void pattern3(int n) {
        for(int i=0;i<n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
