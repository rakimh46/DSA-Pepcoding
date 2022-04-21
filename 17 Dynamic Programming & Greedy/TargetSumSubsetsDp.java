import java.lang.annotation.Target;

public class TargetSumSubsetsDp {
    public static void main(String[] args) {
        int[] coins = { 4, 7, 1, 3};
        int target=10;
        tagetSum(coins,target);
    }

    public static void tagetSum(int[] coins,int target) {
        int nr = coins.length,nc=target;
        boolean[][] dp=new boolean[nr+1][target+1];

        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                if(r==0 && c==0){
                    dp[r][c]=true;
                }else if(r==0){
                    dp[r][c]=false;
                }else if(c==0){
                    dp[r][c]=true;
                }else{
                    int coin=coins[r-1];
                    boolean exc=dp[r-1][c];
                    boolean inc=(c-coin>=0) ? dp[r-1][c-coin] : false;
                    dp[r][c]=exc || inc;
                }
            }
        }

        System.out.println(dp[nr][nc]);

    }
}
