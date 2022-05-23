
import java.util.*;

public class KSumTargetSumUniqueSet {

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        // write your code here
        Arrays.sort(arr);
        List<List<Integer>> res = kSum_(arr, target, 0, k);
        return res;
    }

    private static List<List<Integer>> kSum_(int[] arr, int target, int si, int k) {
        if (k == 2) {
            // base case
            return twoSum(arr, si, arr.length - 1, target);
        }

        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = si; i < n - (k - 1); i++) {
            if (i != si && arr[i] == arr[i - 1])
                continue;

            int val1 = arr[i];
            int targ = target - val1;
            List<List<Integer>> subres = kSum_(arr, targ, i + 1, k - 1);

            for (List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] arr, int st, int end, int target) {
        int left = st;
        int right = end;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (left != st && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);

                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }

}