import java.util.Scanner;

public class findelement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < arr.length) {
            arr[i] = scn.nextInt();
            i++;
        }

        int d = scn.nextInt();

        System.out.println(find(arr, d));

    }

    public static int find(int[] arr, int d) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == d) {
                return i;
            }
            i++;
        }

        return -1;

    }
}
