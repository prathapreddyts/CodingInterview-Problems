package patterns;

public class Patterns {
    public static void main(String[] args) {
        int n = 5;
        int total = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            int start = total - (n - i) + 1;

            for (int j = 0; j < n - i; j++) {
                System.out.print(start + j+" ");
            }

            total = total - (n - i);
            System.out.println();
        }
    }

}
