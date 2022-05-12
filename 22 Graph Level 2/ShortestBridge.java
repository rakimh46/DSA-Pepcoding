import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestBridge {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(shortestBridge(arr));

    }

    public static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public String toString() {
            return r + " " + c;
        }
    }

    public static int shortestBridge(int[][] A) {
        boolean[][] vis = new boolean[A.length][A[0].length];
        Queue<Pair> qu = new ArrayDeque<>();

        boolean flag = false;

        for (int i = 0; i < A.length && !flag; i++) {
            for (int j = 0; j < A[0].length && !flag; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, qu, vis);
                    flag = true;
                }
            }
        }

        System.out.println(qu);

        int level = 0;

        while (qu.size() > 0) {
            int size = qu.size();
            while (size-- > 0) {
                Pair rem = qu.remove();
                for (int d = 0; d < 4; d++) {
                    int rdash = rem.r + dir[d][0];
                    int cdash = rem.c + dir[d][1];

                    if (rdash < 0 || cdash < 0 || rdash >= A.length || cdash >= A[0].length
                            || vis[rdash][cdash] == true) {
                        continue;
                    }

                    if (A[rdash][cdash] == 1) {
                        return level;
                    }

                    qu.add(new Pair(rdash, cdash));
                    vis[rdash][cdash] = true;
                    System.out.println(qu);
                }
            }
            level++;
        }
        return -1;
    }

    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void dfs(int[][] A, int r, int c, Queue<Pair> qu, boolean[][] vis) {
        vis[r][c] = true;
        qu.add(new Pair(r, c));
        for (int d = 0; d < 4; d++) {
            int rdash = r + dir[d][0];
            int cdash = c + dir[d][1];

            if (rdash < 0 || cdash < 0 || rdash >= A.length || cdash >= A[0].length || vis[rdash][cdash] == true
                    || A[rdash][cdash] == 0) {
                continue;
            }

            dfs(A, rdash, cdash, qu, vis);
        }
    }
}
