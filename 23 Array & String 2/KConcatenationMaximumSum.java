public class KConcatenationMaximumSum {
    public static int mod = (int) (Math.pow(10, 9) + 7);   //int mod=(int)1e9 +7; shprtucut way

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        if (k == 1) {
            return kadanes(arr);
        }

        if (k == 2) {
            return (int) (kadanesTwo(arr) % mod);
        }
        long sum = 0;
        // calculate sum of whole array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum < 0) {
            int val = (int) (kadanesTwo(arr) % mod);
            if (val <= 0) {
                return 0;
            }
            return val;
        } else {
            return (int) (kadanesTwo(arr) % mod + ((k - 2) * sum) % mod) % mod;
        }
    }

    public int kadanesTwo(int[] nums) {
        int arr[] = new int[nums.length * 2];
        int i = 0;
        int n = nums.length;
        for (int val : nums) {
            arr[i] = val;
            arr[i + n] = val;
            i++;
        }

        return kadanes(arr);
    }

    public int kadanes(int[] nums) {
        long currentSum = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (sum < currentSum)
                sum = currentSum;

        }
        return (int) sum;
    }
}
