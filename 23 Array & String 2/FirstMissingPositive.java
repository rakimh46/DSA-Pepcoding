public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // HashSet<Integer> map = new HashSet<>();
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        // if(!map.contains(nums[i])) map.add(nums[i]);
        // }

        // for (int i = 1; i <= n; i++) {
        // if (!map.contains(i)) {
        // return i;
        // }
        // }
        // return n + 1;

        // pepecoding
        boolean one=false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) one =true;

            if(nums[i]<1 || nums[i]>nums.length){
                nums[i]=1;
            }
        }

        if(!one){
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int val=Math.abs(nums[i]);
            int idx=val-1;
            nums[idx]=-Math.abs(nums[idx]);
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) return i+1;
        }
        return nums.length+1;
    }


        // leetcode best apprach
    //     int i = 0;
    //     while (i < A.length) {
    //         if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
    //             i++;
    //         else if (A[A[i] - 1] != A[i])
    //             swap(A, i, A[i] - 1);
    //         else
    //             i++;
    //     }
    //     i = 0;
    //     while (i < A.length && A[i] == i + 1)
    //         i++;
    //     return i + 1;
    // }

    // private void swap(int[] A, int i, int j) {
    //     int temp = A[i];
    //     A[i] = A[j];
    //     A[j] = temp;
    // }
}
