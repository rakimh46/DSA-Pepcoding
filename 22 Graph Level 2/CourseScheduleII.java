import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseScheduleII {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] prerequisites = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			prerequisites[i][0] = Integer.parseInt(st[0]);
			prerequisites[i][1] = Integer.parseInt(st[1]);
		}
	
		int[] ans = findOrder(n,prerequisites );

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];
        
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> qu=new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                qu.add(i);
            }
        }

        int count=0;
        boolean[] vis=new boolean[numCourses];
        int[] ans=new int[numCourses];
        while(qu.size()>0){
            int rem=qu.remove();
            vis[rem]=true;
            ans[count]=rem;
            count++;

            ArrayList<Integer> nbrs=graph.get(rem);
            for (int nbr : nbrs) {
                indegree[nbr]--;

                if(vis[nbr]==false && indegree[nbr]==0){
                    qu.add(nbr);
                }
            }
        }
        if(count==numCourses){
            return ans;
        }else{
            return new int[] {-1};
        }
    }
}

			

