import java.util.*;

public class Goldmine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < mine.length; i++) {
            for (int j = 0; j < mine[0].length; j++) {
                mine[i][j] = scn.nextInt();
            }
        }

        gold(mine);
    }

    public static void gold(int[][] mine) {
        int nr = mine.length, nc = mine[0].length;
        int[][] dp = new int[nr][nc];

        for (int c = nc - 1; c >= 0; c--) {
            for (int r = nr - 1; r >= 0; r--) {
                if (c == nc - 1) {
                    dp[r][c] = mine[r][c];
                } else {
                    if (r == 0) {
                        dp[r][c] = mine[r][c] + Math.max(dp[r][c + 1], dp[r + 1][c + 1]);
                    } else if (r == nr - 1) {
                        dp[r][c] = mine[r][c] + Math.max(dp[r - 1][c + 1], dp[r][c + 1]);
                    } else {
                        dp[r][c] = mine[r][c] + Math.max(dp[r - 1][c + 1], Math.max(dp[r][c + 1], dp[r + 1][c + 1]));
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            // System.out.println(dp[i][0]);
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println(max);
    }

}