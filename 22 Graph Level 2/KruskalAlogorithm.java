import java.util.*;

class KruskalAlogorithm {
    public static Scanner scn = new Scanner(System.in);

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

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {

        int vtces = scn.nextInt();
        int n = scn.nextInt();

        Edge[] edge = new Edge[n];

        for (int i = 0; i < n; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();
            edge[i] = new Edge(u, v, wt);
        }

        Arrays.sort(edge);

        UnionFind uf=new UnionFind(vtces+1);
        int cost=0;
        for (Edge e : edge) {
            if(uf.union(e.u, e.v)){
                cost+=e.wt;
            }
        }
        System.out.println(cost);
    }
}