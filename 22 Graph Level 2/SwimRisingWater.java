import java.util.PriorityQueue;

public class SwimRisingWater {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 } };
        System.out.println(swimInWater(grid));
    }

    public static class Pair implements Comparable<Pair> {
        int r, c, maxwt;

        Pair(int r, int c, int maxwt) {
            this.r = r;
            this.c = c;
            this.maxwt = maxwt;
        }

        public int compareTo(Pair o) {
            return this.maxwt - o.maxwt;
        }
    }

    public static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int swimInWater(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));

        while (true) {
            Pair rem = pq.remove();
            if (rem.r == grid.length - 1 && rem.c == grid[0].length - 1) {
                return rem.maxwt;
            }

            if (visited[rem.r][rem.c] == true) {
                continue;
            }
            visited[rem.r][rem.c] = true;

            for (int d = 0; d < 4; d++) {
                int rdash = rem.r + dir[d][0], cdash = rem.c + dir[d][1];
                if (rdash < 0 || cdash < 0 || rdash >= grid.length || cdash >= grid.length
                        || visited[rdash][cdash] == true) {
                    continue;
                }
                pq.add(new Pair(rdash, cdash, Math.max(rem.maxwt, grid[rdash][cdash])));
            }
        }
    }
}
