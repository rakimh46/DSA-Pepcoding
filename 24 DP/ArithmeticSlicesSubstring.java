public class ArithmeticSlicesSubstring {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int omax = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] += dp[i - 1] + 1;
            }else{
                dp[i] = 0;
            }
            omax += dp[i];
        }
        return omax;
    }
}
