import java.util.Scanner;

public class MinCostInMazeTraversal {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] maze=new int[n][m];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j]=scn.nextInt();
            }
        }

        MinCost(maze);
    }

    public static void MinCost(int[][] maze) {
        int n=maze.length,m=maze[0].length;
        int[][] dp=new int[n][m];

        
        for (int i = n-1; i >=0; i--) {
            for (int j =m-1; j >=0; j--) {
                if(i==n-1 && j==m-1){
                    dp[i][j]=maze[i][j];
                }else{
                    if(i==n-1){
                        dp[i][j]=maze[i][j]+dp[i][j+1];
                    }else if(j==m-1){
                        dp[i][j]=maze[i][j]+dp[i+1][j];
                    }else{
                        dp[i][j]=maze[i][j]+Math.min(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
