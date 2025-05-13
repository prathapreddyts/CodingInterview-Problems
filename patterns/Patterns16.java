package patterns;

public class Patterns16 {

    public  void pattern16(int n) {
        for(int i=1;i<=n;i++){
            for(char j='A';j<'A'+i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
