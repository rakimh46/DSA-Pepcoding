public class PartitionArrayIntoDisjointIntervals {

    // O(1)
    public static int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int topmax = nums[0];
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i]) {
                l = i;
                // System.out.println("1"+" "+max+" "+topmax);
                max = topmax;
                continue;
            }
            topmax = Math.max(topmax, nums[i]);
            // System.out.println("2"+" "+topmax);
        }
        return l + 1;
    }

    // O(n)
    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;

        int rightMin[] = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        int leftMax = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= rightMin[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 2, 8, 7 };
        int val = partitionDisjoint(arr);
        System.out.println(val);
    }
}
