import java.util.ArrayList;
import java.util.List;

public class practice {
    public static void main(String[] args) {
        int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        List<Integer> ans = new ArrayList<>();

        for (int j = 0; j < a1.length; j++) {
            ans.add(a1[j]);
        }
        System.err.println(ans);

        // subarray(a1);
        // subset(a1);

    }

    public static void subarray(int[] a1) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a1.length; i++) {
            for (int j = i; j < a1.length; j++) {
                int ans = 0;
                for (int k = i; k <= j; k++) {
                    ans = ans + a1[k];
                }
                if (max < ans) {
                    max = ans;
                }
            }
        }
        System.out.println(max);
    }

    public static void subset(int[] arr) {

        int limit = (int) Math.pow(2, arr.length);

        for (int i = 0; i < limit; i++) {
            int temp = i;
            String set = "";
            for (int j = arr.length - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;

                if (r == 0) {
                    set = "-\t" + set;
                } else {
                    set = arr[j] + "\t" + set;
                }
            }
            System.out.println(set);
        }

    }
}
