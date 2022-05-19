
import java.util.*;

public class SquaresSortedArray {

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return new int[] {};
        }
        int i = 0, j, k;
        int ans[] = new int[nums.length];
        j = k = nums.length - 1;
        
        // while (k >= 0) {
        //     int a = (int) Math.pow(nums[i], 2);
        //     int b = (int) Math.pow(nums[j], 2);
        //     if (a < b) {
        //         ans[k] = b;
        //         j--;
        //     } else {
        //         ans[k] = a;
        //         i++;
        //     }
        //     k--;
        // }

        //leetcode method
        while(i<=j){ // or while(k>=0)
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                ans[k]=nums[i]*nums[i];
                i++;
            }else{
                ans[k]=nums[j]*nums[j];
                j--;
            }
            k--;
        }
        return ans;
    }

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        int[] res = sortedSquares(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
