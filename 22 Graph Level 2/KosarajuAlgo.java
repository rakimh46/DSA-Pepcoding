import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0) {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= E; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
        }
    }
}

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (visited[vtx] == false) {
                dfs1(adj, vtx, visited, st);
            }
        }

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int vtx = 0; vtx < V; vtx++) {
            rev.add(new ArrayList<Integer>());
        }

        for (int vtx = 0; vtx < V; vtx++) {
            ArrayList<Integer> nbrs = adj.get(vtx);
            for (int nbr : nbrs) {
                rev.get(nbr).add(vtx);
            }
        }

        int count = 0;
        visited = new boolean[V];
        while (st.size() > 0) {
            int vtx = st.pop();
            if (visited[vtx] == false) {
                count++;
                dfs2(rev, vtx, visited);
            }
        }
        return count;

    }

    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited, Stack<Integer> st) {
        visited[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs1(adj, nbr, visited, st);
            }
        }
        st.push(vtx);
    }

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited) {
        visited[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs2(adj, nbr, visited);
            }
        }
    }
}
