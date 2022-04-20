//Minimum Wire Required To Connect All Pcs

import java.io.*;
import java.util.*;

public class MinimumWeightRequired {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class MSTPair implements Comparable<MSTPair> {
        int vtx, pvtx, wt;

        MSTPair(int vtx, int pvtx, int wt) {
            this.vtx = vtx;
            this.pvtx = pvtx;
            this.wt = wt;
        }

        public int compareTo(MSTPair o) {
            return this.wt - o.wt;
        }
    }

    public static void minimumSpan(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<MSTPair> pq = new PriorityQueue<>();
        pq.add(new MSTPair(0, -1, 0));
        while (pq.size() > 0) {
            MSTPair pair = pq.remove();
            if (visited[pair.vtx] == true) {
                continue;
            }
            visited[pair.vtx] = true;
            if (pair.pvtx != -1) {
                System.out.println("[" + pair.vtx + "-" + pair.pvtx + "@" + pair.wt + "]");
            }
            for (Edge e : graph[pair.vtx]) {
                if (visited[e.nbr] == false) {
                    pq.add(new MSTPair(e.nbr, pair.vtx,e.wt));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        minimumSpan(graph);
    }

}