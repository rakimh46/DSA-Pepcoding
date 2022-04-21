import java.util.Scanner;

public class CountBinaryStrings {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n=scn.nextInt();
            countBinary(n);
        }
    }

    public static void countBinary(int n) {
        // int[][] dp = new int[2][n + 1];
        // for (int j = 1; j <= n; j++) {
        //     if(j==1){
        //         dp[0][1]=dp[1][1]=1;
        //     }else{
        //         dp[0][j]=dp[1][j-1];
        //         dp[1][j]=dp[0][j-1]+dp[1][j-1];
        //     }
        // }
        // System.out.println(dp[0][n]+dp[1][n]);

        int count0=1;
        int count1=1;

        for (int i = 2; i <=n; i++) {
            int temp0=count0;
            count0=count1;
            count1=temp0+count1;
        }

        System.out.println(count0+count1);


    }
}
