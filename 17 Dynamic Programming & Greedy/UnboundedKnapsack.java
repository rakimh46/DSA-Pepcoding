import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] vls = new int[n];
            for (int i = 0; i < n; i++) {
                vls[i] = scn.nextInt();
            }
            int[] wts = new int[n];
            for (int i = 0; i < n; i++) {
                wts[i] = scn.nextInt();
            }
            int cap = scn.nextInt();
            unboundedKnapsack(vls, wts, cap);
        }
    }

    public static void unboundedKnapsack(int[] vls, int[] wts, int cap) {
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for (int i = 1; i <= cap; i++) {
            for (int j = 0; j < wts.length; j++) {
                if (wts[j] <= i) {
                    int exc = dp[i];
                    int inc = dp[i - wts[j]] + vls[j];
                    dp[i] = Math.max(exc, inc);
                }
            }
        }
        // for (int i : dp) {
        //     System.out.println(i);
        // }
        System.out.println(dp[cap]);
    }
}
