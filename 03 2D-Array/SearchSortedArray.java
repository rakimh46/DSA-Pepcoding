//Search In A Sorted 2d Array
/**
 * SearchSortedArray
 */
public class SearchSortedArray {

    public static void main(String[] args) {
        int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, {41,42,43,44} };
        int x = 44;

        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println(i + " " + j);
                return;
            } else if (x > arr[i][j]) {
                i++;
            } else if (x < arr[i][j]) {
                j--;
            }
        }
        System.out.println("not found");
    }
}