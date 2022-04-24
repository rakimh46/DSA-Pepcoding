public class CountSort {
    public static void main(String[] args) {
        int arr[] = { 7, -2, 4, 1, 3, 4, 1, -2, 7 };
        count(arr);
    }

    public static void count(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int nue = max - min + 1; // nue =no of inique elements
        System.out.println(nue);

        int[] freq = new int[nue];
        for (int val : arr) {
            freq[val - min]++;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        int[] res = new int[arr.length];

        for (int i = res.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = val - min;
            int place = freq[pos];
            res[place - 1] = val;
            freq[pos]--;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
