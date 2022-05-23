
import java.util.*;

public class MaxProductOfThreeNumbers {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] nums) {
        // write your code here
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int val : nums) {
            if (val > max1) {
                max3 = max2;
                max2 = max1;
                max1 = val;
            } else if (val > max2) {
                max3 = max2;
                max2 = val;
            } else if (val > max3) {
                max3 = val;
            }

            if (val < min1) {
                min2 = min1;
                min1 = val;
            } else if (min2 > val) {
                min2 = val;
            }
        }

        return Math.max(max1 * min1 * min2, max1 * max2 * max3);
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
