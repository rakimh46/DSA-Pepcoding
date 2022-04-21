import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            long count0=1;
            long count1=1;

            for (int i = 2; i <=n; i++) {
                long temp0=count0;
                count0=count1;
                count1=temp0+count1;
            }
            long ans=(count0+count1)*(count0+count1);
            System.out.println(ans);
        }
    }
}
