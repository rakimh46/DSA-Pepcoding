import java.util.*;

public class SortDates {

    public static void sortDates(String[] arr) {
        // write your code
        countSort(arr, 1000000, 100, 32);// days
        countSort(arr, 10000, 100, 13);// month
        countSort(arr, 1, 10000, 2501);// year

    }

    public static void countSort(String[] arr, int div, int mod, int range) {
        // write your code here
        int[] freq = new int[range];
        for (String val : arr) {
            freq[(Integer.parseInt(val, 10) / div) % mod]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        String res[] = new String[arr.length];

        for (int i = res.length - 1; i >= 0; i--) {
            int val = Integer.parseInt(arr[i], 10);
            int pos = (val / div) % mod;
            int place = freq[pos];
            res[place - 1] = arr[i];
            freq[pos]--;
        }

        for (int i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String str = scn.next();
                arr[i] = str;
            }
            sortDates(arr);
            print(arr);
        }
    }

}