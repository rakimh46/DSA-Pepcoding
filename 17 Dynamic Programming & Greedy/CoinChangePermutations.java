
import java.util.*;

public class CoinChangePermutations {

    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = scn.nextInt();
            }
            int target = scn.nextInt();

            Permutations(coins, target);
        }
    }

    public static void Permutations(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin=coins[j];
                if(coin<=i){
                    dp[i]+=dp[i-coin];
                }
            }
        }
        System.out.println(dp[target]);
    }
}