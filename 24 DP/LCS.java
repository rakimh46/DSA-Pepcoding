import java.util.Scanner;

public class LCS {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str1 = scn.next();
        String str2 = scn.next();
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);

            }
        }
        System.out.println(dp[0][0]);
    }
}
