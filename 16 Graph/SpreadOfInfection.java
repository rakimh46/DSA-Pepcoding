import java.io.*;
import java.util.*;

public class SpreadOfInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class tPair {
        int vtx;
        int t;

        tPair(int vtx, int t) {
            this.vtx = vtx;
            this.t = t;
        }
    }

    public static int CountSpreadOfInfection(ArrayList<Edge>[] graph, int src, int t) {
        int count = 0;
        boolean[] visited = new boolean[graph.length];
        Queue<tPair> qu = new ArrayDeque<>();
        qu.add(new tPair(src, 1));
        while (qu.size() > 0) {
            tPair pair = qu.remove();
            // if (pair.t > t) {
            // break;
            // } else {
            // if (visited[pair.vtx] == false) {
            // visited[pair.vtx] = true;
            // count++;
            // for (Edge e : graph[pair.vtx]) {
            // if (visited[e.nbr] == false) {
            // qu.add(new tPair(e.nbr, pair.t + 1));
            // }
            // }
            // }
            // }
            if (visited[pair.vtx] == true) {
                continue;
            }
            visited[pair.vtx] = true;
            if (pair.t > t) {
                break;
            }
            count++;
            for (Edge e : graph[pair.vtx]) {
                if (visited[e.nbr] == false) {
                    qu.add(new tPair(e.nbr, pair.t + 1));
                }
            }

        }
        return count;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here
        System.out.println(CountSpreadOfInfection(graph, src, t));
    }

}