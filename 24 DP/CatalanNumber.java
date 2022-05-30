import java.util.*;

public class CatalanNumber {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int l = 0, r = i - 1; l < i; l++, r--) {
                temp += dp[l] * dp[r];
            }
            dp[i] = temp;
        }
        System.out.println(dp[n]);
    }

}
