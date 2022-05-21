public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        // fast and leetcode method
        // int n=nums.length;
        // int[] result = new int[n];
        // for (int i = 0, tmp = 1; i < n; i++) {
        // result[i] = tmp;
        // tmp *= nums[i];
        // }

        // for (int i = n - 1, tmp = 1; i >= 0; i--) {
        // result[i] *= tmp;
        // tmp *= nums[i];
        // }
        // return result;

        // 2nd method
        int n = nums.length;
        int[] left = new int[n]; // left
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        int[] right = new int[n]; // right
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] result = new int[n]; // ans
        result[0] = right[1];
        result[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
            System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 3, 5 };
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + "  ");
        }
    }
}
