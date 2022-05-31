//Count Palindromic Subsequences
import java.util.*;

public class CPS {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scn.next();
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; j++, i++) {
                if (d == 0) {
                    dp[i][j] = 1;
                } else if (d == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                        continue;
                    }
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

}
