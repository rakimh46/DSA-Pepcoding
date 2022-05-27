import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static Scanner scn = new Scanner(System.in);

    public int lengthOfLIS(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length];
        int omax = 0;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
}
