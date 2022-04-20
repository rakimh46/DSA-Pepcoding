
import java.io.*;
import java.util.*;

public class ShortestPathInWeights {
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

    public static class SPIWPair implements Comparable<SPIWPair>{
        int vtx;
        String psf;
        int wsf;
        SPIWPair(int vtx,String psf,int wsf){
            this.vtx=vtx;
            this.psf=psf;
            this.wsf=wsf;
        }
        public int compareTo(SPIWPair o){
            return this.wsf - o.wsf;
        }
    }
    public static void shortestPathInWeights(ArrayList<Edge>[] graph,int src) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<SPIWPair> pq = new PriorityQueue<>();
        pq.add(new SPIWPair(src, src+"",0));
        while(pq.size()>0){
            SPIWPair pair=pq.remove();
            if(visited[pair.vtx]==true){
                continue;
            }
            visited[pair.vtx]=true;
            System.out.println(pair.vtx+" via "+pair.psf+" @ "+pair.wsf);
            for (Edge e : graph[pair.vtx]) {
                if(visited[e.nbr]==false){
                    pq.add(new SPIWPair(e.nbr, pair.psf+e.nbr, pair.wsf+e.wt));
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

        int src = Integer.parseInt(br.readLine());
        // write your code here
        shortestPathInWeights(graph, src);

    }
}