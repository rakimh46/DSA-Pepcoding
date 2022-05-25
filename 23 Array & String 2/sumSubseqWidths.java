import java.util.Arrays;

public class sumSubseqWidths {
    public int sumSubseqWidths1(int[] A) {

        int MOD = (int) 1e9 + 7; // 1000000007
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i - 1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N - 1 - i]) * A[i]) % MOD;

        return (int) ans;

    }
}
