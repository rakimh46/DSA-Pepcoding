/**
 * The saddle price is defined as the least price in the row but the maximum
 * price in the column of the matrix.
 */

public class SaddlePrice {
    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };

        for (int i = 0; i < arr.length; i++) {
            int lvj = 0; // lowest value j
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] < arr[i][lvj]) {
                    lvj = j;
                }
            }

            boolean flag = true;

            for (int k = 0; k < arr.length; k++) {
                if (arr[k][lvj] > arr[i][lvj]) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                System.out.println(arr[i][lvj]);
                return;
            }
        }
        System.out.println("invalid");
    }

}
