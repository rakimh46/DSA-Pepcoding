import java.util.Arrays;

public class Pairdiff {
    public static boolean findPair(int arr[], int size, int n) {
        if (arr.length == 1)
            return false;
        // code here.
        Arrays.sort(arr);
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            int diff = Math.abs(arr[j] - arr[i]);
            if (diff == n && i != j) {
                System.out.println(i + "  " + j);
                return true;
            } else if (diff > n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 6 };
        System.out.println(findPair(arr, arr.length, 0));
    }
}