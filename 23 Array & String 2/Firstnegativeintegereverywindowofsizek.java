public class Firstnegativeintegereverywindowofsizek {
    public long[] printFirstNegativeInteger(long A[], int N, int K) {

        long[] ans = new long[A.length - (K - 1)];
        int index = N;

        for (int i = N - 1; i >= N - K; i--) {
            if (A[i] < 0) {
                index = i;
            }
        }

        for (int i = N - K; i >= 0; i--) {
            if (A[i] < 0) {
                index = i;
            }
            if (index < i + K) {
                ans[i] = A[index];
            }
        }
        return ans;
    }
}
