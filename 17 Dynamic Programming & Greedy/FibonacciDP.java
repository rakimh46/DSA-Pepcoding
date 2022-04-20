public class FibonacciDP {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Recursion = " + fiboR(n));
        System.out.println("Memorization = " + fiboM(n, new int[n + 1]));
        System.out.println("Tabulation = " + fiboT(n));
    }

    public static int fiboR(int n) { // Recursion
        if (n <= 1) {
            return n;
        }

        return fiboR(n - 1) + fiboR(n - 2);
    }

    public static int fiboM(int n, int[] dp) { // memorization
        if (n <= 1) {
            return dp[1] = n;
        }
        // if(n==2){
        // return dp[2]=1;
        // }
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fiboM(n - 1, dp) + fiboM(n - 2, dp);
    }

    public static int fiboT(int n) { // tabulation
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}