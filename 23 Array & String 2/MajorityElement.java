
//Moore voting algorithm
import java.util.*;

public class MajorityElement {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] nums) {
        int ele = majorityElement(nums);
        int count = 0;
        for (int val : nums) {
            if (val == ele) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            System.out.println(ele);
        } else {
            System.out.println("No Majority Element exist");
        }
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int val = nums[0];
        int i = 1;
        int count = 1;
        while (i != nums.length) {
            if (nums[i] == val) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    val = nums[i];
                    count++;
                }
            }
            i++;
        }
        if (count == 0) {
            return 0;
        }
        return val;
    }

    public int majority(int[] nums) {// hashmap
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        int maxNum = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (var entry : map.entrySet()) {
            int val = entry.getValue();
            if (val > len / 2) {
                if (val > max) {
                    max = val;
                    maxNum = entry.getKey();
                }

            }

        }
        return maxNum;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
