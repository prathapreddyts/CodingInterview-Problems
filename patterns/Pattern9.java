package patterns;

public class Pattern9 {
    public static void main(String[] args) {
        pattern9(5);
    }
    public static void pattern9(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n) {
                for (int j = 0; j < n - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < i - n + 1; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k < 2 * (2 * n - i) - 1; k++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
