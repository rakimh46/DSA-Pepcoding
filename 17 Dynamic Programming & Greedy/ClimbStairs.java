import java.util.*;

public class ClimbStairs {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            System.out.println(climb(n));
        }
    }

    public static int climb(int n) {
        int[] dp=new int[n+1];
        for (int i = 0; i <=n; i++) {
            if(i==0){
                dp[0]=1;
            }else if(i==1){
                dp[1]=1;
            }else if(i==2){
                dp[2]=2;
            }else{
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
    }
}
