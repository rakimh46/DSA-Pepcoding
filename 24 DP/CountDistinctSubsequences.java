import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctSubsequences {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scn.next();

        long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        HashMap<Character, Long> map = new HashMap<>();
        for (int i = 1; i <= str.length(); i++) {
            if (!map.containsKey(str.charAt(i - 1))) {
                map.put(str.charAt(i - 1), dp[i - 1]);
                dp[i] = dp[i - 1] * 2;
            } else {
                dp[i] = dp[i - 1] * 2 - map.get(str.charAt(i - 1));
                map.put(str.charAt(i - 1), dp[i - 1]);
            }
        }
        System.out.println(dp[str.length()]);
        // System.out.println(dp[str.length()]-1); if with non empty string

    }
}
