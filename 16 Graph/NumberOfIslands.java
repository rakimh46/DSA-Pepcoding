
// Number Of Islands
// 1. You are given a 2d array where 0's represent land and 1's represent water. 
//      Assume every cell is linked to it's north, east, west and south cell.
// 2. You are required to find and count the number of islands.
// input
// 8
// 8
// 0 0 1 1 1 1 1 1
// 0 0 1 1 1 1 1 1
// 1 1 1 1 1 1 1 0
// 1 1 0 0 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 1 1 1 0
// 1 1 1 1 1 1 1 0

import java.io.*;

public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        System.out.println(noOfIsland(arr));
        // write your code here
    }

    public static int noOfIsland(int[][] arr) {
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == false && arr[i][j] == 0) {
                    gcc(visited, arr, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void gcc(boolean[][] visited, int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || j >= arr[0].length || i >= arr.length || visited[i][j] == true || arr[i][j] == 1)
            return;
        visited[i][j] = true;
        gcc(visited, arr, i - 1, j); // north
        gcc(visited, arr, i, j + 1); // east
        gcc(visited, arr, i + 1, j); // south
        gcc(visited, arr, i, j - 1); // west
    }

}