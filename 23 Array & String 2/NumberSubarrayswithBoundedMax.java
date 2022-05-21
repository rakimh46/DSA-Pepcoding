public class NumberSubarrayswithBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = -1;
        int ei = -1;
        int count = 0;
        //leetcode
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                si = ei = i;
                continue;
            }
            if (nums[i] >= left) {
                ei = i;
            }
            count += ei - si;
        }
        return count;

        //coaching
        // int si = 0;
        // int ei = 0;
        // int count = 0;
        // int prev = 0;
        // while (ei < nums.length) {
        // if (left <= nums[ei] && nums[ei] <= right) {
        // prev = ei - si + 1;
        // count += prev;
        // } else if (nums[ei] < left) {
        // count += prev;
        // } else if (nums[ei] > right) {
        // si = ei + 1;
        // prev = 0;
        // }
        // ei++;
        // }
        // return count;
    }
}
