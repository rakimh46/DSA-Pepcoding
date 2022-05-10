import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//Minimum cost to connect all cities
public class MinimumCostConnectallcities {
    public static Scanner scn = new Scanner(System.in);

    public static class Edge {
        int src, nbr, wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int vtx,wt;

        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static long solve(ArrayList<Edge>[] graph) {
        int nvtces = graph.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));
        boolean[] vis = new boolean[nvtces];
        long ans = 0;

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.vtx] == true) {
                continue;
            }

            vis[rem.vtx] = true;
            System.out.println(rem.vtx);
            ans += rem.wt;

            for (Edge e : graph[rem.vtx]) {
                if (vis[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, e.wt));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nvtces = scn.nextInt(); // vertices

        ArrayList<Edge>[] graph = new ArrayList[nvtces+1];

        for(int i = 0 ; i <= nvtces ; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <=nvtces; i++) {
            for (int j = 0; j <=nvtces; j++) {
                int v1=scn.nextInt();
                if(v1!=0){
                    graph[i].add(new Edge(i, j, v1));
                }
            }
        }


        long mincost = solve(graph);
        System.out.println(mincost);

    }
}
