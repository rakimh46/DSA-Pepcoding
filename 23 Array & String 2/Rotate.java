public class Rotate {
    // first transpose
    // second change left to right column each other
    public static void rotate(int[][] matrix) {
        // write your code here
        transpose1(matrix);
        reverseRow(matrix);

    }

    public static void transpose1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseRow(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            int left = 0;
            int right = arr[r].length - 1;

            while (left < right) {
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];
                arr[r][right] = temp;

                left++;
                right--;
            }
        }
    }
}
