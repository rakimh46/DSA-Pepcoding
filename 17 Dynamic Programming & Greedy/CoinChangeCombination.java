
import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = scn.nextInt();
            }
            int target = scn.nextInt();

            combination(coins, target);
        }
    }

    public static void combination(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < dp.length; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[target]);
    }
}