import java.io.*;
import java.util.*;

public class IsGraphBipartite {
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

    public static boolean IsBipartite(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                boolean res = IsCompatiableBipartite(graph, vtx, visited);
                if (res == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class BPair{
        int vtx;
        int level;
        BPair(int v,int l){
            vtx=v;
            level=l;
        }
    }

    public static boolean IsCompatiableBipartite(ArrayList<Edge>[] graph,int src,boolean[] visited){
        Queue<BPair> qu=new ArrayDeque<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        qu.add(new BPair(src, 0));
        while (qu.size()>0) {
            BPair pair=qu.remove();
            if(visited[pair.vtx]==true){
                if(pair.level%2!=hm.get(pair.vtx)%2){
                    return false;
                }
            }else{
                hm.put(pair.vtx, pair.level);
                visited[pair.vtx]=true;
                for(Edge e:graph[pair.vtx]){
                    if(visited[e.nbr]==false){
                        qu.add(new BPair(e.nbr, pair.level+1));
                    }
                }
            }
        }
        return true;
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
        System.out.println(IsBipartite(graph));
    }
}