
import java.io.*;
import java.util.*;

public class Print01Knapsack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        // write your code here
        knapsack(wts, values, cap);

    }

    public static void knapsack(int[] wt, int[] values, int cap) {
        int n = wt.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    int exc = dp[i - 1][j];

                    int inc = 0;
                    if (j >= wt[i - 1]) {
                        inc = values[i - 1] + dp[i - 1][j - wt[i - 1]];
                    }
                    dp[i][j] = Math.max(exc, inc);
                }
            }
        }
        System.out.println(dp[n][cap]);
        printPath(dp, values, wt);
    }

    public static class Pair {
        int i;
        int j;
        String psf;

        Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void printPath(int[][] dp, int[] values, int[] wt) {
        int n = dp.length - 1;
        int cap = dp[0].length - 1;
        ArrayDeque<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(n, cap, ""));
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            int i = rem.i;
            int j = rem.j;
            String psf = rem.psf;
            if (i == 0 || j == 0) {
                System.out.println(psf);
                continue;
            }
            int exc = dp[i - 1][j];
            int inc = 0;
            if (j >= wt[i - 1]) {
                inc = values[i - 1] + dp[i - 1][j - wt[i - 1]];
            }

            if (dp[i][j] == exc) {
                pq.add(new Pair(i - 1, j, psf));
            }
            if (dp[i][j] == inc) {
                if (j >= wt[i - 1]) {
                    pq.add(new Pair(i - 1, j - wt[i - 1], (i - 1) + " " + psf));
                }
            }
        }
    }
}
