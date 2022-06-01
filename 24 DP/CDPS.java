//Count Of Distinct Palindromic Subsequences
import java.util.*;

public class CDPS {

    public static int solution(String str) {
        // write your code here
        int n = str.length();
        long mod = (int) (Math.pow(10, 9) + 7);
        HashMap<Character, Integer> map = new HashMap<>();
        int[] next = new int[str.length()];
        int[] prev = new int[str.length()];

        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            next[i] = map.getOrDefault(ch, -1);
            map.put(ch, i);
        }
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            prev[i] = map.getOrDefault(ch, -1);
            map.put(ch, i);
        }

        int[][] dp = new int[n][n];
        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; j++, i++) {
                if (d == 0) {
                    dp[i][j] = 1;
                } else if (d == 1) {
                    dp[i][j] = 2;
                } else {
                    if (str.charAt(i) != str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        if (next[i] > prev[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (next[i] == prev[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            int N = next[i];
                            int P = prev[j];
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[N + 1][P - 1];
                        }
                    }
                }
                dp[i][j] = (int) ((dp[i][j] + mod) % mod);
            }
        }
        return dp[0][n - 1];
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.next();
        System.out.println(solution(str));
    }

}
