
import java.io.*;
import java.util.*;

public class GetConnectedComponentsOfAGraph {
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

        ArrayList<ArrayList<Integer>> allcomps = new ArrayList<>();

        // write your code here
        gcc(graph, allcomps);

        System.out.println(allcomps);
    }

    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> allcomps) {
        // ArrayList<ArrayList<Integer>> allcomps = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                ArrayList<Integer> res = new ArrayList<>();
                gcc(graph, vtx, res, visited);
                allcomps.add(res);
            }
        }

        return allcomps;
    }

    public static void gcc(ArrayList<Edge>[] graph, int vtx, ArrayList<Integer> res, boolean[] visited) {
        res.add(vtx);
        visited[vtx] = true;
        for (Edge e : graph[vtx]) {
            if (visited[e.nbr] == false) {
                gcc(graph, e.nbr, res, visited);
            }
        }
    }
}

// input
// 7
// 5
// 0 1 10
// 2 3 10
// 4 5 10
// 5 6 10
// 4 6 10