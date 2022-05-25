import java.util.*;

public class InsertIntervals {

    public static int[][] insertIntervals(int intervalList[][], int newInterval[]) {
        // write your code here
        ArrayList<int[]> ans = new ArrayList<>();

        int idx = 0;

        while (idx < intervalList.length) {
            if (intervalList[idx][0] < newInterval[0]) {
                ans.add(intervalList[idx]);
                idx++;
                continue;
            }
            break;
        }

        if (ans.size() == 0 || newInterval[0] > ans.get(ans.size() - 1)[1]) {
            ans.add(newInterval);
        } else {
            int[] lastinterval = ans.get(ans.size() - 1);
            // System.out.println(ans.get(ans.size() - 1)[0] + " " + ans.get(ans.size() -
            // 1)[1]);
            lastinterval[1] = Math.max(lastinterval[1], newInterval[1]);
            // System.out.println(ans.get(ans.size() - 1)[0] + " " + ans.get(ans.size() -
            // 1)[1]);
            // ans.set(ans.size() - 1, lastinterval); we donot need bz its directly change
            // in arraylist
        }

        while (idx < intervalList.length) {
            int[] lastinterval = ans.get(ans.size() - 1);
            if (lastinterval[1] >= intervalList[idx][0]) {
                // merging
                lastinterval[1] = Math.max(lastinterval[1], intervalList[idx][1]);
                // ans.set(ans.size() - 1, lastinterval);
            } else {
                ans.add(intervalList[idx]);
            }
            idx++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    // best
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                result.add(in);
            } else if (newInterval[1] < in[0]) {
                result.add(newInterval);
                // smart move
                newInterval = in;
            } else {
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int intervalList[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            int st = scn.nextInt();
            int et = scn.nextInt();

            intervalList[i][0] = st;
            intervalList[i][1] = et;
        }
        int newInterval[] = new int[2];
        newInterval[0] = scn.nextInt();
        newInterval[1] = scn.nextInt();

        int ans[][] = insertIntervals(intervalList, newInterval);

        System.out.print("[");
        for (int interval[] : ans) {
            System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");

    }
}
