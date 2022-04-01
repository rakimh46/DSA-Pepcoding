
import java.util.ArrayList;
import java.util.List;

/**
 * DisplayArray
 */
public class DisplayArrayReverse {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(display(arr, 0));
    }

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> display(int[] arr, int idx) {
        if (idx == arr.length) {
            return new ArrayList<Integer>();
        }
        // System.out.println(arr[idx]);

        display(arr, idx + 1);
        ans.add(arr[idx]);
        return ans;
    }
}