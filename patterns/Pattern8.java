package patterns;

public class Pattern8 {
    public static void main(String[] args) {
        pattern8(5);
    }
    public static void pattern8(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int l=0;l<2*n-(2*i+1);l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
