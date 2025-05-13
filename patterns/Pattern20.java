package patterns;

public class Pattern20 {

    public void pattern20(int n) {
        int spaces = 2 * n - 2;
        int rows = 2 * n - 1;
        for (int i = 1; i <= rows; i++) {
            if (i < n) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                for (int k = 1; k <= spaces; k++) {
                    System.out.print(" ");
                }
                for (int l = 1; l <= i; l++) {
                    System.out.print("*");
                }
                spaces -= 2;
            } else {

                for (int j = 1; j <= 2 * n - i; j++) {
                    System.out.print("*");
                }
                for (int k = 1; k <= spaces; k++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * n - i; j++) {
                    System.out.print("*");
                }
                spaces += 2;

            }
            System.out.println();
        }
    }


}
