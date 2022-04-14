import java.util.HashMap;
import java.util.Map;

public class GetCommonElements {
    public static void main(String[] args) {
        int arr1[] = { 5, 5, 9, 8, 5, 5, 8, 0, 3 };
        int arr2[] = { 9, 7, 1, 0, 3, 6, 5, 9, 1, 1, 8, 0, 2, 4, 2, 9, 1, 5 };
        Map<Integer, Boolean> hm = new HashMap<>();

        
        for(int val: arr1){
            hm.put(val, true);
        }

        for(int val: arr2){
            if(hm.containsKey(val)){
                System.out.println(val);
                hm.remove(val);
            }
        }
    }
}
