package patterns;

public class Pattern14 {

    public void pattern14(int n) {
        for(int i=0;i<n;i++){
           for(char j='A';j<='A'+i;j++) {
               System.out.print(j);
           }
            System.out.println();
        }

    }
}
