
import java.util.*;

public class LargestSquareSubmatrix1s {

    public static int solution(int[][] arr) {
        // write your code here
        int[][] dp = new int[arr.length][arr[0].length];
        int max = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (arr[i][j] == 0 || j == dp[0].length - 1 || i == dp.length - 1) {
                    dp[i][j] = arr[i][j] == 1 ? 1 : 0;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // leetcode
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res * res;
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(solution(arr));
    }

}