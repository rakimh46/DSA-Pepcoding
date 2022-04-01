import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30 };

        System.out.println( ans(arr));
        
    }

    static List<List<Integer>> res=new ArrayList<List<Integer>>();

    public static List<List<Integer>> ans(int[] arr) {
        List<Integer> curr = new ArrayList<>();
        subset(0,curr,arr);
        return res;
    }

    public static void subset(int start,List<Integer> curr,int[] arr){
        res.add(new ArrayList<Integer>(curr));

        for (int i = start; i < arr.length; i++) {
            curr.add(arr[i]);
            subset(i+1,curr,arr);
            curr.remove(curr.size()-1);
        }
    }
}
