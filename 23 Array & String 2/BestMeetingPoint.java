import java.util.ArrayList;
import java.util.Collections;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        ArrayList<Integer> xCod = new ArrayList<>();
        ArrayList<Integer> yCod = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xCod.add(i);
                    yCod.add(j);
                }
            }
        }
        Collections.sort(yCod);

        // for (int j = 0; j < grid[0].length; j++) {
        // for (int i = 0; i < grid.length; i++) {
        // if (grid[i][j] == 1) {
        // yCod.add(j);
        // }
        // }
        // }

        int x = xCod.get(xCod.size() / 2);
        int y = yCod.get(yCod.size() / 2);

        int distance = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    distance += Math.abs(x - i) + Math.abs(y - j);
                }
            }
        }
        return distance;
    }
}