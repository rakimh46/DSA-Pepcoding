import java.util.*;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int maxlen = 0;

        for (int i = 0; i < dp.length; i++) {

            // find the index of heioght of envelope[i]
            int index = binarySearch(dp, 0, maxlen, envelopes[i][1]);

            dp[index] = envelopes[i][1];

            if (index == maxlen) {
                maxlen++;
            }

        }
        return maxlen;
    }

    int binarySearch(int[] arr, int start, int end, int target) {
        int index = Arrays.binarySearch(arr, start, end, target);
        if (index < 0) {
            index = -(index + 1);
        }
        return index;
    }
}
