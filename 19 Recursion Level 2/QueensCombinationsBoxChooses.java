//Queens Combinations - 2d As 2d - Box Chooses
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensCombinationsBoxChooses {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        // write your code here
        if (row == tq) {
            if (qpsf == tq) {

                System.out.println(asf);
            }
            return;
        }
        String sep;
        int nr, nc;
        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            sep = "\n";
        } else {
            nr = row;
            nc = col + 1;
            sep = "";
        }
        queensCombinations(qpsf + 1, tq, nr, nc, asf + "q" + sep);
        queensCombinations(qpsf, tq, nr, nc, asf + "-" + sep);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}