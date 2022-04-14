import java.util.HashMap;

public class GetCommonElementSecond {

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 2, 2, 3, 5 };
        int arr2[] = { 1, 1, 1, 2, 2, 4, 5 };
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int val : arr1) {
            if (hm.containsKey(val)) {
                hm.put(val, hm.get(val) + 1);
            } else {
                hm.put(val, 1);
            }
        }
        for (int val : arr2) {
            if (hm.containsKey(val)) {
                if (hm.get(val) != 0) {
                    hm.put(val, hm.get(val) - 1);
                    System.out.println(val);
                }
            }
        }

    }
}