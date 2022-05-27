public class Maximumsumincreasingsubsequence {
    public int maxSumIS(int arr[], int n) {
        // code here.
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[arr.length];
        int omax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + arr[i];
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
}
