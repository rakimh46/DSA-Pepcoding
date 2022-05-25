import java.util.Collections;
import java.util.PriorityQueue;

public class CarFleet {
    // pepcoding
    public class Pair implements Comparable<Pair> {
        int pos;
        int speed;

        Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public int compareTo(Pair o) {
            return this.pos - o.pos;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        // int[] time=new int[position.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            pq.add(new Pair(position[i], speed[i]));
        }

        double max = 0;
        int fleet = 0;
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            double time = (target - rem.pos) / (rem.speed * 1.0);
            if (time > max) {
                max = time;
                fleet++;
            }
        }
        return fleet;
    }

    // leetcode
    public int carFleet2(int target, int[] position, int[] speed) {
        int[] road = new int[target];

        // Storing speeds for cars in indexes corresponding to position
        for (int i = 0; i < position.length; i++) {
            road[position[i]] = speed[i];
        }

        // Iterate backwards from furthest car up to find slowest cars that block other
        // cars
        double max = 0;
        int fleet = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (road[i] > 0) {
                double time = (double) (target - i) / road[i];
                if (time > max) {
                    max = time;
                    fleet++;
                }
            }
        }
        return fleet;
    }
}