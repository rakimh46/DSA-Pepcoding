public class barchart {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 0, 7, 5 };
        chart(arr);
    }

    public static void chart(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int floor = max; floor >= 1; floor--) {
            for (int i = 0; i < arr.length; i++) {
                if (floor <= arr[i]) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();

        }

    }
}
