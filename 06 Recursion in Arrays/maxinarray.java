public class maxinarray {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 33, 44, 55, 66, 77, 21, 11 };

        System.out.println(maxarray(arr, 0));
    }

    public static int maxarray(int[] arr, int idx) {

        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int max = maxarray(arr, idx + 1);
        if (max > arr[idx]) {
            return max;
        } else {
            return arr[idx];
        }
    }
}
