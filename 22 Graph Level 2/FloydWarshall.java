import java.io.*;

public class FloydWarshall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    public void shortest_distance(int[][] matrix) {
        int INF = Integer.MAX_VALUE;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = INF;
            }
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][k] < INF && matrix[k][j] < INF
                            && matrix[i][k] + matrix[k][j] < INF)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= INF)
                    matrix[i][j] = -1;
            }
        }
    }
}
