import java.util.*;

public class MaximumNonoverlappingBridges {

    public static Scanner scn = new Scanner(System.in);

    public static class Bridge implements Comparable<Bridge> {
        int nc;
        int sc;

        Bridge(int nc, int sc) {
            this.nc = nc;
            this.sc = sc;
        }

        public int compareTo(Bridge o) {
            if (this.nc == o.nc) {// this situation using same value not overlapping
                return this.sc - o.sc;
            } else {
                return this.nc - o.nc;
            }
        }
    }

    public static void main(String[] args) {
        int n = scn.nextInt();

        ArrayList<Bridge> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int n1 = scn.nextInt();
            int n2 = scn.nextInt();
            Bridge brd = new Bridge(n1, n2);
            arr.add(brd);
        }
        System.out.println(MNOB(arr));
    }

    // with equal value present in north side bridge this situation using same value
    // not overlapping
    public static int MNOB(ArrayList<Bridge> arr) {

        Collections.sort(arr);

        ArrayList<Integer> sq = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (sq.size() == 0 || sq.get(sq.size() - 1) < arr.get(i).sc) {
                sq.add(arr.get(i).sc);
            } else {
                int ci = findCeil(sq, arr.get(i).sc);
                sq.set(ci, arr.get(i).sc);
            }
        }
        return sq.size();
    }

    public static int findCeil(ArrayList<Integer> sq, int num) {
        int li = 0, hi = sq.size();
        int ci = -1;
        while (li <= hi) {
            int mid = (hi + li) / 2;
            if (sq.get(mid) == num) {
                return mid;
            } else if (sq.get(mid) < num) {
                li = mid + 1;
            } else {
                hi = mid - 1;
                ci = mid;
            }
        }
        return ci;
    }

    // without euaql value include line82 arr[j].nc < arr[i].nc this situation using
    // same value overlapping
    public int lengthOfLIS2(Bridge[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].sc < arr[i].sc && arr[j].nc < arr[i].nc) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }

}
