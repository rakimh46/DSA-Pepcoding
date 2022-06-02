import java.util.*;

public class LongestRepeatingSubsequence {

    public static int solution(String str) {
        // write your code here
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }

        }
        return dp[0][0];
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.next();
        System.out.println(solution(str));
    }

}