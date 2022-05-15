import java.util.*;

public class NoOfIslandsII {
    public static void main(String[] args) {
        // int[][] positions = { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };
        Point arr[] = new Point[4];
        arr[0] = new Point(1, 1);
        arr[1] = new Point(0, 1);
        arr[2] = new Point(3, 3);
        arr[3] = new Point(3, 4);
        System.out.println(numIslands2(4, 5, arr));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class UnionFind {
        int par[];
        int rank[];
        int count;

        UnionFind(int vtx) {
            par = new int[vtx];
            rank = new int[vtx];
            count = 0;
            Arrays.fill(par, -1);
        }

        void init(int idx) {
            count++;
            par[idx] = idx;
        }

        void union(int v1, int v2) {
            int rt1 = find(v1);
            int rt2 = find(v2);

            if (rt1 != rt2) {
                count--;
                int rank2 = rank[v2];
                int rank1 = rank[v1];

                if (rank1 > rank2) {
                    par[rt2] = rt1;
                } else if (rank1 < rank2) {
                    par[rt1] = rt2;
                } else {
                    par[rt2] = rt1;
                    rank[rt1]++;
                }
            }
        }

        int find(int vtx) {
            if (par[vtx] == vtx) {
                return vtx;
            }
            return par[vtx] = find(par[vtx]);
        }
    }

    public static List<Integer> numIslands2(int n, int m, Point[] positions) {
        // write your code here
        if (positions == null) {
            return new ArrayList<Integer>();
        }
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        ArrayList<Integer> res = new ArrayList<>();
        UnionFind obj = new UnionFind(m * n);
        int mat[][] = new int[n][m];

        for (Point pos : positions) {
            int r = pos.x;
            int c = pos.y;

            int idx = r * m + c;
            if (mat[r][c] != 1) {
                mat[r][c] = 1;
                obj.init(idx);
                for (int d = 0; d < 4; d++) {
                    int rdash = r + dir[d][0];
                    int cdash = c + dir[d][1];
                    if (rdash < 0 || cdash < 0 || rdash >= mat.length || cdash >= mat[0].length
                            || mat[rdash][cdash] != 1) {
                        continue;
                    }
                    int newIdx = rdash * m + cdash;
                    obj.union(idx, newIdx);
                }
            }
            res.add(obj.count);
        }
        return res;
    }
}
