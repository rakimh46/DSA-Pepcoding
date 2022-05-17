import java.util.*;

class ArticulationPoint {
  public static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {

    int nvtces = scn.nextInt();
    int nedges = scn.nextInt();

    int edges[][] = new int[nedges][2];

    for (int i = 0; i < edges.length; i++) {
      int u = scn.nextInt();
      int v = scn.nextInt();
      edges[i][0] = u;
      edges[i][1] = v;
    }

    System.out.println(articulationpoint(edges, nvtces));
  }

  static int[] dis;
  static int[] low;
  static int[] par;
  static boolean[] ap;
  static boolean[] vis;
  static int time;
  static int count;

  public static int articulationpoint(int[][] edges, int nvtces) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < nvtces + 1; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];

      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    dis = new int[nvtces + 1];
    low = new int[nvtces + 1];
    par = new int[nvtces + 1];
    ap = new boolean[nvtces + 1];
    vis = new boolean[nvtces + 1];
    time = 1;
    count = 0;

    dfs(1, graph);

    int res = 0;
    for (int j = 1; j <= nvtces; j++) {
      if (ap[j]) {
        // System.out.println(j);
        res++;
      }
    }
    return res;
  }

  public static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
    dis[u] = time;
    low[u] = time;
    vis[u] = true;
    time++;
    for (Integer v : graph.get(u)) {
      if (par[u] == v) {
        continue;
      } else if (vis[v] == true) {
        low[u] = Math.min(low[u], dis[v]);
      } else {
        par[v] = u;
        dfs(v, graph);
        if (par[u] == 0) {
          count++;
          if (count >= 2) {
            ap[u] = true;
          }
        } else if (low[v] >= dis[u]) {
          ap[u] = true;
        }
        low[u] = Math.min(low[u], low[v]);
      }
    }
  }

}