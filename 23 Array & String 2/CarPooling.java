import java.util.Scanner;

public class CarPooling {
    public static Scanner scn = new Scanner(System.in);

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] trip = new int[1001];
        int maxend = 0;

        for (int i = 0; i < trips.length; i++) {
            int start = trips[i][1];
            int end = trips[i][2];
            int passCount = trips[i][0];

            trip[start] += passCount;
            trip[end] -= passCount;
            maxend = Math.max(maxend, end);
        }
        int prefixSum = 0;
        for (int i = 0; i <= maxend; i++) {
            prefixSum += trip[i];

            trip[i] = prefixSum;
            if (trip[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}
