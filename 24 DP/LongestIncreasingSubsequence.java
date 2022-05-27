import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static Scanner scn = new Scanner(System.in);

    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sq = new ArrayList<>(); // sequence arraylist

        for (int i = 0; i < nums.length; i++) {
            if (sq.size() == 0 || sq.get(sq.size() - 1) < nums[i]) {
                sq.add(nums[i]);
            } else {
                int ci = findCeil(sq, nums[i]);
                sq.set(ci, nums[i]);
            }
        }
        return sq.size();
    }

    public int findCeil(ArrayList<Integer> sq, int num) {
        int li = 0, hi = sq.size();
        int ci = -1;
        while (li <= hi) {
            int mid = (hi + li) / 2;
            if (sq.get(mid) == num) {
                return mid;
            } else if (sq.get(mid) < num) {
                li = mid + 1;
            } else {
                hi = mid - 1;
                ci = mid;
            }
        }
        return ci;
    }

    // O(n2)
    public int lengthOfLIS2(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length];
        int omax = 0;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
}
