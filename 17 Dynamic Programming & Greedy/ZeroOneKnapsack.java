
public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] vls = { 15, 14, 10, 45, 30 };
        int[] wts = { 2, 5, 1, 3, 4 };
        int cap = 7;
        Knapsack(vls, wts, cap);
    }

    public static void Knapsack(int[] vls, int[] wts, int cap) {
        int[][] dp = new int[wts.length + 1][cap + 1];
        for (int i = 1; i <= wts.length; i++) {
            int wt =wts[i-1];
            int vl=vls[i-1];
            for (int j = 1; j <=cap; j++) {
                int exc=dp[i-1][j];
                int inc=(j-wt>=0) ?(vl+dp[i-1][j-wt]) : 0;
                dp[i][j]=Math.max(exc, inc);
            }
        }

        System.out.println(dp[wts.length][cap]);
    }

}