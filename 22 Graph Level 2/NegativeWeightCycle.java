import java.util.*;
import java.io.*;

class NegativeWeightCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                String S2[] = br.readLine().trim().split(" ");
                for (int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        // code here
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i < n-1; i++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                if (res[u] != Integer.MAX_VALUE && res[u] + wt < res[v]) {
                    res[v] = res[u] + wt;
                }
            }
        }

        for (int idx = 0; idx < edges.length; idx++) {
            int e[] = edges[idx];
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if (res[u] != Integer.MAX_VALUE && res[u] + wt < res[v]) {
                return 1;
            }
        }
        return 0;

    }
}