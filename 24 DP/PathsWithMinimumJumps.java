import java.util.ArrayDeque;
import java.util.Scanner;

public class PathsWithMinimumJumps {
    public static void Solution(int arr[]) {
        // write your code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                if (dp[i + j] < min) {
                    min = dp[i + j];
                }
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

        printPath(dp, arr);
    }

    public static class pair {
        int i;
        String psf;

        pair(int i, String psf) {
            this.i = i;
            this.psf = psf;
        }
    }

    public static void printPath(int dp[], int arr[]) {
        ArrayDeque<pair> pq = new ArrayDeque<>();
        pq.add(new pair(0, "0"));

        while (pq.size() > 0) {
            pair rem = pq.remove();

            if (rem.i == arr.length - 1) {
                System.out.println(rem.psf + " . ");
                continue;
            }

            for (int j = 1; j <= arr[rem.i] && rem.i + j < arr.length; j++) {
                if (dp[rem.i + j] == dp[rem.i] - 1) {
                    pq.add(new pair(rem.i + j, rem.psf + " -> " + (rem.i + j)));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
