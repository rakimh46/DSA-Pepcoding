public class findMaxAverage {
    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i];
            sum = sum - nums[i - k];
            max = Math.max(max, sum);
        }

        return (max * 1.0) / k;
    }
}
