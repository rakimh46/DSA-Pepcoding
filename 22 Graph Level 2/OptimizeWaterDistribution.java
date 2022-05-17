import java.io.*;
import java.util.Arrays;

public class OptimizeWaterDistribution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);

        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }

    static class UnionFind {
        int par[];
        int size[];

        UnionFind(int vtx) {
            par = new int[vtx];
            size = new int[vtx];
            for (int i = 0; i < vtx; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        boolean union(int v1, int v2) {
            int rt1 = find(v1);
            int rt2 = find(v2);

            if (rt1 != rt2) {
                if (size[rt1] >= size[rt2]) {
                    par[rt2] = rt1;
                    size[rt1] += size[v2];
                } else if (size[v1] < size[rt2]) {
                    par[rt1] = rt2;
                    size[rt2] += size[rt1];
                    ;
                }
                return true;
            }
            return false;
        }

        int find(int vtx) {
            if (par[vtx] == vtx) {
                return vtx;
            }
            return par[vtx] = find(par[vtx]);
        }
    }

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }

        public String toString() {
            return u + " " + v + " " + wt;
        }
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(pipes.length + n);
        Pair[] edge = new Pair[pipes.length + n];
        int i = 0;
        for (int j = 0; j < wells.length; j++) { // well and house
            edge[i] = new Pair(0, j + 1, wells[j]);
            i++;
        }
        for (int[] e : pipes) { // house and pipes
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            edge[i] = new Pair(u, v, wt);
            i++;
        }
        Arrays.sort(edge);

        int cost = 0;
        for (Pair e : edge) {
            if (uf.union(e.u, e.v)) {
                cost += e.wt;
            }
        }
        return cost;
    }
}
