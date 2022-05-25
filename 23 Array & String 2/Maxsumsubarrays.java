//https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1#
public class Maxsumsubarrays {
    public static long pairWithMaxSum(long arr[], long N) {
        // Your code goes here
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            max = Math.max(max, arr[i] + arr[i + 1]);
        }
        return max;
    }
}
