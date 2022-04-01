public class inversearr {
    public static void main(String[] args) {
        int[] arr = { 4, 0, 2, 3, 1 };

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i]] = i;
        }
        display(ans);
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
