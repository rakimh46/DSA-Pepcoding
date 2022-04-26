import java.io.*;


public class NqueensPermutations2dAs1dQueenChooses {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        for (int i = 0, j = col; i < chess.length; i++) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        for (int i = row, j = 0; j < chess[0].length; j++) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        for (int i = row + 1, j = col + 1; i < chess.length && j < chess[0].length; i++, j++) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if (qpsf == tq) {
            for (int[] arr : chess) {
                for (int val : arr) {
                    System.out.print(val == 0 ? "-\t" : "q" + val + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < tq * tq; i++) {
            int row = i / tq;
            int col = i % tq;
            if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
