import java.util.Scanner;

public class perfectSquare {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
