
import java.util.*;

public class WiggleSort1 {

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static void wiggleSort(int[] arr) {
        // write your code here
        for (int i = 0; i < arr.length - 1; i++) {
            //
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        wiggleSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
