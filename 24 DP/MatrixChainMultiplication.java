import java.util.*;

public class MatrixChainMultiplication {

    public static int mcm(int[] arr) {
        // write your code here
        int[][] dp = new int[arr.length - 1][arr.length - 1];

        for (int d = 1; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp[0].length; i++, j++) {
                if (d == 1) {
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                } else {
                    int min = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        int lans = dp[i][k];
                        int rans = dp[k + 1][j];

                        int mc = arr[i] * arr[k + 1] * arr[j + 1]; // mult cost

                        int cont = lans + rans + mc;
                        min = Math.min(min, cont);
                    }

                    dp[i][j] = min;
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }

    public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm(arr));
    }

}