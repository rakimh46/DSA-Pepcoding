public class nQueens {
    public static void main(String[] args) {
        int n = 4;
        printqueens(new int[n][n], "", 0);
    }

    public static void printqueens(int[][] chess, String csf, int row) {
        if (row == chess.length) {
            System.out.println(csf + ".");
            return;
        }

        for (int col = 0; col < chess[0].length; col++) {
            if (issafe(chess, row, col)) {
                chess[row][col] = 1;
                printqueens(chess, csf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean issafe(int[][] chess, int row, int col) {

        for (int i = row - 1, j = col; i >= 0; i--) { // up
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--) { // up left diagonal
            if (chess[i][j] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; j++, i--) { // up right diagonal
            if (chess[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
