package patterns;

public class Pattern11 {

    public  void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j <= i; j++) {
                    if (j % 2 == 0) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                }
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j % 2 == 0) {
                        System.out.print(0);
                    } else {
                        System.out.print(1);
                    }
                }

            }
            System.out.println();
        }
    }

}
