import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // method 1
    public static int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int cmax = 0;
        int omax = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (start[i] < end[j]) {
                cmax++;
                i++;
            } else {
                cmax--;
                j++;
            }
            omax = Math.max(omax, cmax);
        }
        return omax;
    }

    // method 2
    public int minMeetingRooms2(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval val : intervals) {
            if (pq.size() == 0) {
                pq.add(val.end);
            } else {
                if (pq.peek() > val.start) {
                    pq.add(val.end);
                } else {
                    pq.remove();
                    pq.add(val.end);
                }
            }
        }
        return pq.size();
    }

}
