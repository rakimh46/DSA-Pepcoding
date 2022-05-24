import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomsI {
    public static boolean meetingRooms(int intervals[][]) {
        // write code here
        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (val1, val2) -> Integer.compare(val1[0], val2[0]));
        int lsp = intervals[0][0];
        int lep = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int sp = intervals[i][0];
            int ep = intervals[i][1];

            if (lep <= sp) {
                lsp = sp;
                lep = ep;
            } else {
                return false;
            }
        }

        return true;

    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String args[]) {

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}
