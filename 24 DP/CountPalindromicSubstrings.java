public class CountPalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abccbc";
        System.out.println(countSubstrings(str));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;
        for (int d = 0; d < dp.length; d++) {
            for (int i = 0, j = d; j < dp.length; j++, i++) {
                if (d == 0) {
                    dp[i][j] = true;
                } else if (d == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                count = dp[i][j] == true ? count + 1 : count;
            }
        }
        return count;
    }
}
