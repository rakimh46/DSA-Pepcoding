import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int lsp = intervals[0][0];
        int lep = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int sp = intervals[i][0];
            int ep = intervals[i][1];

            if (lep < sp) {
                int[] sublist = { lsp, lep };
                list.add(sublist);
                lsp = sp;
                lep = ep;
            } else if (lep < ep) {
                lep = ep;
            } else {
                // lep>ep
            }
        }
        int[] sublist = { lsp, lep };
        list.add(sublist);

        return list.toArray(new int[list.size()][]);

    }
}
