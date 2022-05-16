public class cutslahes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int k = n + 1;
        par = new int[k * k];
        for (int i = 0; i < k * k; i++) {
            par[i] = i;
        }
        rank = new int[k * k];
        count = 0;

        for (int i = 1; i < k; i++) {
            int c1 = i;
            int c2 = k * (k - 1) + i;
            int c3 = k * i;
            int c4 = k * (i + 1) - 1;

            union(0, c1);
            union(0, c2);
            union(0, c3);
            union(0, c4);
        }

        for (int i = 0; i < n; i++) {
            String str = grid[i];
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == ' ') {
                    continue;
                } else if (ch == '/') {
                    int c1 = i * k + (j + 1);
                    int c2 = (i + 1) * k + j;
                    union(c1, c2);
                } else {
                    int c1 = i * k + j;
                    int c2 = (i + 1) * k + (j + 1);
                    union(c1, c2);
                }
            }
        }
        return count;
    }

    int[] par;
    int[] rank;
    int count;

    private int find(int x) {
        if (par[x] == x) {
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }

    private void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx == ly) {
            count++;
        } else {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                par[lx] = ly;
            } else {
                par[ly] = lx;
                rank[lx]++;
            }
        }
    }
}
