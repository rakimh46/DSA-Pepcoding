import java.util.*;
import java.io.*;

public class MotherVertex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (visited[vtx] == false) {
                dfs1(adj, vtx, visited, st);
            }
        }

        count = 0;
        dfs2(adj, st.peek(), new boolean[V]);
        if (count == V) {
            return st.peek();
        } else {
            return -1;
        }

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

    static int count;

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited) {
        visited[vtx] = true;
        count++;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs2(adj, nbr, visited);
            }
        }
    }

}
