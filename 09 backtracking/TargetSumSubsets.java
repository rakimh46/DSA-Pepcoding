public class TargetSumSubsets {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int x = 60;
        print(arr, 0, "", 0, x);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void print(int[] arr, int i, String set, int sos, int tar) {

        if (i == arr.length) {
            if (tar == sos) {
                System.out.println(set+".");
            }
            return;
        }
        print(arr, i + 1, set + arr[i] + ",", sos + arr[i], tar);
        print(arr, i + 1, set, sos, tar);

    }
}
