import java.util.*;

public class BoxStacking {
    public static class Box implements Comparable<Box> {
        int h, w, l, area;

        public Box(int h, int w, int l) {
            this.h = h;
            this.w = w;
            this.l = l;
        }

        public int compareTo(Box o) {
            return this.area - o.area;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        // Code here
        int count = 3 * n;
        Box[] arr = new Box[count];

        for (int i = 0; i < n; i++) {
            arr[3 * i] = new Box(height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i]));
            arr[3 * i + 1] = new Box(width[i], Math.max(height[i], length[i]), Math.min(height[i], length[i]));
            arr[3 * i + 2] = new Box(length[i], Math.max(width[i], height[i]), Math.min(width[i], height[i]));
        }

        for (int i = 0; i < count; i++) {
            arr[i].area = arr[i].l * arr[i].w;
        }

        Arrays.sort(arr);

        int omax = 0;
        int[] dp = new int[count];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].l < arr[i].l && arr[j].w < arr[i].w) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + arr[i].h;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
}
