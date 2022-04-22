import java.util.Scanner;

public class PaintHouseManyColors {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int c = scn.nextInt();
            int[][] ColorRate = new int[n][c];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < c; j++) {
                    ColorRate[i][j] = scn.nextInt();
                }
            }

            int[][] dp = new int[n][c];
            int least = Integer.MAX_VALUE;
            int sleast = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = ColorRate[0][j];
                if (dp[0][j] <= least) {
                    sleast = least;
                    least = dp[0][j];
                } else if (dp[0][j] <= sleast) {
                    sleast = dp[0][j];
                }
            }

            for (int i = 1; i < dp.length; i++) {
                int nleast = Integer.MAX_VALUE;
                int nsleast = Integer.MAX_VALUE;
                for (int j = 0; j < dp[0].length; j++) {
                    if (dp[i - 1][j] != least) {
                        dp[i][j] = least + ColorRate[i][j];
                    } else {
                        dp[i][j] = sleast + ColorRate[i][j];
                    }

                    if (dp[i][j] <= nleast) {
                        nsleast = nleast;
                        nleast = dp[i][j];
                    } else if (dp[i][j] <= nsleast) {
                        nsleast = dp[i][j];
                    }
                }
                least = nleast;
                sleast = nsleast;
            }
            System.out.println(least);

            // int[][] dp=new int[n][k];
            // for (int j = 0; j < ColorRate[0].length; j++) {
            // dp[0][j]=ColorRate[0][j];
            // }

            // for (int i = 1; i < dp.length; i++) {
            // for (int j = 0; j < dp[0].length; j++) {
            // int min=Integer.MAX_VALUE;
            // for (int j2 = 0; j2 < dp[0].length; j2++) {
            // if(j2!=j){
            // if(dp[i-1][j2]<min){
            // min=dp[i-1][j2];
            // }
            // }
            // dp[i][j]=ColorRate[i][j]+min;
            // }
            // }
            // }

            // int min=Integer.MAX_VALUE;
            // for (int j = 0; j < dp[0].length; j++) {
            // if(min>dp[dp.length-1][j]){
            // min=dp[dp.length-1][j];
            // }
            // }
            // System.out.println(min);

        }
    }
}
