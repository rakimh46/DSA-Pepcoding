
import java.util.*;

public class MaxChunksMakeArraySorted2 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int[] rightmin = new int[arr.length + 1];
        rightmin[arr.length] = Integer.MAX_VALUE;

        for (int i = rightmin.length - 2; i >= 0; i--) {
            rightmin[i] = Math.min(rightmin[i + 1], arr[i]);
        }
        int chunk = 0;
        int lefftmax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            lefftmax = Math.max(lefftmax, arr[i]);
            if (lefftmax <= rightmin[i + 1]) {
                chunk++;
            }
        }

        return chunk;

    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
