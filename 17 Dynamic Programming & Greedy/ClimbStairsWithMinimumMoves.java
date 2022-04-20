import java.util.*;

public class ClimbStairsWithMinimumMoves {

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(ClimbwithMinMoves(arr, n));
        }
    }

    public static int ClimbwithMinMoves(int[] arr, int n) {

        Integer[] dp = new Integer[n + 1];
        for (int i = n; i >= 0; i--) {
            if (i == n) {
                dp[n] = 0;
            } else {
                if (arr[i] > 0) {
                    int min = Integer.MAX_VALUE;
                    for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
                        if (dp[i + jump] != null) {
                            min = Math.min(min, dp[i + jump]);
                        }
                        if (min != Integer.MAX_VALUE) {
                            dp[i] = min + 1;
                        }
                    }
                }
            }
        }
        // 2nd method format
        // int[] dp = new int[arr.length + 1];
        // for (int i = n; i >= 0; i--) {
        // if (i == n) {
        // dp[n] = 0;
        // } else {
        // int maxjump = arr[i];
        // if (maxjump == 0) {
        // dp[i] = Integer.MAX_VALUE;
        // } else {
        // int min = Integer.MAX_VALUE;
        // for (int jump = 1; jump <= maxjump && jump + i <= n; jump++) {
        // if (dp[i + jump] != Integer.MAX_VALUE) {
        // min = Math.min(min, dp[i + jump]);
        // }
        // }
        // if (min != Integer.MAX_VALUE) {
        // dp[i] = min + 1;
        // }else{
        // dp[i]=Integer.MAX_VALUE;
        // }
        // }
        // }
        // }
        return dp[0];
    }
}
