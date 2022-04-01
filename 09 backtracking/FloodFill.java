import java.util.ArrayList;

/**
 * FloodFill
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] arr = { { 0, 0, 0 },
                { 1, 0, 1 },
                { 0, 0, 0 } };
        flood(arr, 0, 0, "", new boolean[arr.length][arr[0].length]);
    }

    public static void flood(int[][] maze, int r, int c, String psf, boolean [][]visited) {

        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == 1 || visited[r][c]) {
            return;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }
        visited[r][c] = true;

        flood(maze, r - 1, c, psf + 't', visited);// top
        flood(maze, r, c - 1, psf + 'l', visited);// Left
        flood(maze, r + 1, c, psf + 'd', visited);// down
        flood(maze, r, c + 1, psf + 'r', visited);// right

        visited[r][c] = false;

    }
}