import java.util.*;

public class RadixSort {

    public static void radixSort(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        int count = 0;
        while (max != 0) {
            count++;
            max /= 10;
        }

        for (int i = 0, exp = 1; i < count; i++, exp = exp * 10) {
            countSort(arr, exp);
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        int[] freq = new int[10];
        for (int val : arr) {
            freq[(val / exp) % 10]++;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }
        int[] res = new int[arr.length];
        for (int i =res.length-1; i>=0;i--) {
            int val = arr[i];
            int pos = (val / exp) % 10;
            int place = freq[pos];
            res[place - 1] = val;
            freq[pos]--;
        }
        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            radixSort(arr);
            print(arr);
        }
    }

}