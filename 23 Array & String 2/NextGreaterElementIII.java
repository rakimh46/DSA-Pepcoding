
import java.util.*;

public class NextGreaterElementIII {

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        // write your code here
        char[] arr = str.toCharArray();

        int dipIndx = dipIndex(arr);
        if (dipIndx == -1) {
            String s = "-1";
            return s;
        }

        int ceilIndx = ceilIndex(arr, dipIndx);
        swap(dipIndx, ceilIndx, arr);
        reverse(dipIndx + 1, arr);
        return String.valueOf(arr);

    }

    public static void reverse(int left, char[] arr) {
        int right = arr.length - 1;
        while (left < right) {
            swap(left, right, arr);
            left++;
            right--;
        }
    }

    public static void swap(int left, int right, char[] arr) {
        char ch = arr[left];
        arr[left] = arr[right];
        arr[right] = ch;
    }

    public static int dipIndex(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        return i;
    }

    public static int ceilIndex(char[] arr, int i) {
        int j = arr.length - 1;
        while (j >= 0) {
            if (arr[j] > arr[i]) {
                return j;
            }
            j--;
        }
        return -1;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}