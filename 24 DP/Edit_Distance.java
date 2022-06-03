public class Edit_Distance {
    public int minDistanceDP(String word1, String word2) { // dp
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == word1.length() && j == word2.length()) {
                    return 0;
                } else if (j == word2.length()) {
                    dp[i][j] = word1.length() - i;
                } else if (i == word1.length()) {
                    dp[i][j] = word2.length() - j;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                    // i+1 j+1 replace
                    // i+1 j deletion
                    // i j+1 insertion
                }
            }
        }
        return dp[0][0];
    }

    public int minDistance(String word1, String word2) { // recursion
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        return helper(word1, 0, word2, 0, dp);
    }

    public int helper(String word1, int i, String word2, int j, int[][] dp) {
        if (i == word1.length() && j == word2.length()) {
            return 0;
        }

        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, i + 1, word2, j + 1, dp);
        }

        int replace = helper(word1, i + 1, word2, j + 1, dp);
        int deletion = helper(word1, i + 1, word2, j, dp);
        int insertion = helper(word1, i, word2, j + 1, dp);

        dp[i][j] = Math.min(replace, Math.min(deletion, insertion)) + 1;

        return dp[i][j];
    }
}
