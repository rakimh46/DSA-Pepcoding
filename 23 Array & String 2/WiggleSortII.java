import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        // int n = nums.length;
        // int[] arr = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = nums[i];
        // }
        // Arrays.sort(arr);

        // int j = n - 1;
        // int i = 1;

        // while (i < n) {
        // nums[i] = arr[j];
        // j--;
        // i += 2;
        // }
        // i = 0;
        // while (i < n) {
        // nums[i] = arr[j];
        // j--;
        // i += 2;
        // }
        int[] count = new int[5001];
        for (int num : nums) {
            count[num]++;
        }
        int last = count.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            while (count[last] == 0)
                last--;
            nums[i] = last;
            count[last]--;
        }
        for (int i = 0; i < nums.length; i += 2) {
            while (count[last] == 0)
                last--;
            nums[i] = last;
            count[last]--;
        }

    }
}
