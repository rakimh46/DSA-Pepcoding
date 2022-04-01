import java.util.*;

public class GridPath {
    public static void main (String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l : 
        while(t-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int[][] dp = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = sc.nextInt();
                    dp[i][j] = arr[i][j];
                }
            }
            if(n==1 && m==1) {
                System.out.println("YES");
                continue l;
            }
            for(int i=n-1; i>=0; i--) {
                for(int j=m-1; j>=0; j--) {
                    if(i==0 && j==0) break;
                    else if(i==n-1 && j==m-1) {
                        int l = (n>1) ? arr[n-2][m-1] : 0;
                        int r = (m>1) ? arr[n-1][m-2] : 0;
                        if (arr[n-1][m-1] != l+r) {
                            System.out.println("NO");
                            continue l;
                        }
                        dp[i][j]=0;
                        dp[i-1][j]=0;
                        dp[i][j-1]=0;
                    }
                    else if(j==0) {
                        if(dp[i-1][j] < arr[i][j]) {
                            System.out.println("NO");
                            continue l;
                        }
                        dp[i-1][j]-=arr[i][j];
                    } else if(i==0) {
                        if(dp[i][j-1] < arr[i][j]) {
                            System.out.println("NO");
                            continue l;
                        }
                        dp[i][j-1]-=arr[i][j];
                    } else {
                        if(dp[i][j-1] > arr[i][j]) {
                            System.out.println("NO");
                            continue l;
                        }
                        int rem = arr[i][j]-dp[i][j-1];
                        dp[i][j-1]=0;
                        if(rem > dp[i-1][j]) {
                            System.out.println("NO");
                            continue l;
                        }
                        dp[i-1][j] -= rem;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(dp[i][j] != 0) {
                        System.out.println("NO");
                        continue l;
                    }
                }
            }
            System.out.println("YES");
        }
    }
}