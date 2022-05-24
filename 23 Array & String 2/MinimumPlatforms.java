
import java.util.*;

public class MinimumPlatforms {

    public static int findPlatform(int[] arr, int[] dep) {
        // write your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int cmax = 0, omax = 0;

        while (i < dep.length) {
            if (arr[i] <= dep[j]) {
                cmax++;
                i++;
            } else if (arr[i] > dep[j]) {
                cmax--;
                j++;
            }
            omax = Math.max(omax, cmax);
        }
        return omax;
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dep[i] = scn.nextInt();
        }

        int plateforms = findPlatform(arr, dep);
        System.out.println(plateforms);
    }
}
