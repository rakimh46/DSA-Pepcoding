
import java.io.*;
import java.util.*;

public class IterativeDepthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class DFSPair{
        int vtx;
        String psf;
        DFSPair(int vtx,String psf){
            this.vtx=vtx;
            this.psf=psf;
        }
    } 

    public static void DFS(ArrayList<Edge>[] graph,int src) {
        Stack<DFSPair> st=new Stack<>();
        boolean visited[]=new boolean[graph.length];
        st.push(new DFSPair(src, src+""));
        while(st.size()>0){
            DFSPair pair=st.pop();
            if(visited[pair.vtx]==true){
                continue;
            }
            visited[pair.vtx]=true;
            System.out.println(pair.vtx+"@"+pair.psf);
            for (Edge e : graph[pair.vtx]) {
                if(visited[e.nbr]==false){
                    st.push(new DFSPair(e.nbr, pair.psf+e.nbr));
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        DFS(graph, src);
    }
}