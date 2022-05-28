import java.util.Arrays;

public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, res = 0;
        for (int[] arr : pairs) {
            if (arr[0] > cur) {
                cur = arr[1];
                res++;
            }
        }
        return res;

    }
}
