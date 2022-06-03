import java.util.*;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);

        for (int i = 2; i <= n; i++) {
            int un = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                un = Math.min(un, primes[j] * dp[ptr[j]]);
            }
            dp[i] = un;

            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[ptr[j]] == un) {
                    ptr[j]++;
                }
            }

        }
        return dp[n];
    }

    // by heap O(kLogn)
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Pair(primes[i], 1, primes[i]));
        }

        for (int i = 2; i < dp.length; i++) {
            dp[i] = pq.peek().val;

            while (pq.peek().val == dp[i]) {
                Pair rem = pq.poll();
                pq.add(new Pair(rem.prime * dp[rem.ptr], rem.ptr + 1, rem.prime));
            }
        }
        return dp[n];
    }

    private class Pair implements Comparable<Pair> {
        int val;
        int ptr;
        int prime;

        Pair(int val, int ptr, int prime) {
            this.val = val;
            this.ptr = ptr;
            this.prime = prime;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}