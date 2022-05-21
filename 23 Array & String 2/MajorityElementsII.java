import java.util.*;

public class MajorityElementsII {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1 = arr[0];
        int count1 = 1;
        int val2 = arr[0];
        int count2 = 0;
        int i = 1;
        while (i != arr.length) {
            int nval = arr[i];
            if (arr[i] == val1) {
                count1++;
            } else if (arr[i] == val2) {
                count2++;
            } else {
                if (count1 == 0) {
                    val1 = nval;
                    count1++;
                } else if (count2 == 0) {
                    val2 = nval;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
            ++i;
        }
        count1 = 0;
        count2 = 0;
        for (int val : arr) {
            if (val == val1) {
                count1++;
            }
            if (val == val2) {
                count2++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (count1 > arr.length / 3) {
            ans.add(val1);
        }
        if (count2 > arr.length / 3) {
            ans.add(val2);
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}