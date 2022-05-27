import java.util.Scanner;

public class LongestBitonicSubsequence {
    public static int lbs(int[] arr) {
        // lis
        int[] lis = new int[arr.length];

        for (int i = 0; i < lis.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, lis[j]);
                }
            }

            lis[i] = max + 1;
        }

        // lds
        int[] lds = new int[arr.length];

        for (int i = lis.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, lds[j]);
                }
            }

            lds[i] = max + 1;
        }

        // lbs
        int ans = 0;
        for (int i = 0; i < lds.length; i++) {
            int len = lis[i] + lds[i] - 1;
            ans = Math.max(ans, len);
        }

        return ans;
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();

        }

        System.out.println(lbs(arr));
    }
}
