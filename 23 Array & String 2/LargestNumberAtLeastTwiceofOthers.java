public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                index = i;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i]; 
            }
        }
        // System.out.println(max1+" "+max2);
        return max2 * 2 <= max1 ? index : -1;
    }

    public static void main(String[] args) {
    }
}
