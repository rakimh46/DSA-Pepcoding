import java.util.Scanner;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] ele = new int[n];
            for (int i = 0; i < n; i++) {
                ele[i] = scn.nextInt();
            }

            int count0 = 0;
            int count1 = ele[0];
            for (int i = 1; i < ele.length; i++) {
            int temp0 = Math.max(count0, count1);
            count1 = count0 + ele[i];
            count0 = temp0;
            }
            System.out.println(Math.max(count0, count1));


        }
    }
}
