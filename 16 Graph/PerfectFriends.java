import java.util.*;

public class PerfectFriends {
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
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = 0;
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        
        // write your code here
        ArrayList<ArrayList<Integer>> allcomps = new ArrayList<>();
        gcc(graph, allcomps);

        int res=0;
        for (int i = 0; i < allcomps.size(); i++) {
            for (int j = i+1; j < allcomps.size(); j++) {
                ArrayList<Integer> ith=allcomps.get(i);
                ArrayList<Integer> jth=allcomps.get(j);
                res+=ith.size()*jth.size();
            }
        }
        System.out.println(res);

        // 2nd method combination 
        // int ans=factorial(n)/(factorial(n-2)*factorial(2));
        // for (int i = 0; i < allcomps.size(); i++) {
        //     ArrayList<Integer> ith=allcomps.get(i);
        //     ans=ans-factorial(ith.size())/(factorial(ith.size()-2)*factorial(2));
        // }
        // System.out.println(ans);
    }

    public static int factorial(int a) {
        if(a==1){
            return 1;
        }
        return a*factorial(a-1);
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