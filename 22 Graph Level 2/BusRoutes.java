import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class BusRoutes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStop = routes[i][j];

                ArrayList<Integer> busNo = map.getOrDefault(busStop, new ArrayList<>());
                busNo.add(i);
                map.put(busStop, busNo);
            }
        }

        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(S);
        HashSet<Integer> busStopVis = new HashSet<>();
        HashSet<Integer> busNoVis = new HashSet<>();
        busStopVis.add(S);

        int level = 0;
        while (qu.size() > 0) {
            int size = qu.size();
            while (size-- > 0) {
                int rem = qu.remove();
                if (rem == T) {
                    return level;
                }

                ArrayList<Integer> buses = map.get(rem);
                for (int busNo : buses) {
                    if (busNoVis.contains(busNo) == true) {
                        continue;
                    }

                    int[] arr = routes[busNo];
                    for (int busStopNo : arr) {
                        if (busStopVis.contains(busStopNo) == true) {
                            continue;
                        }
                        qu.add(busStopNo);
                        busStopVis.add(busStopNo);
                    }
                    busNoVis.add(busNo);
                }
            }
            level++;
        }
        return -1;

    }
}
