public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int prod = 1;
        int res = Integer.MIN_VALUE;

        // left product
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, nums[i]);
                prod = 1; // for identity of product
            } else {
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }

        // right product
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                res = Math.max(res, nums[i]);
                prod = 1; // for identity of product
            } else {
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { -2, 0, -4 }));
    }
}
