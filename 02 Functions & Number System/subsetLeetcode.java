import java.util.ArrayList;
import java.util.List;

public class subsetLeetcode {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }

    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return res;

        bt(0, new ArrayList<Integer>(), nums);
        return res;
    }

    public static void bt(int start, ArrayList<Integer> curr, int[] nums) {

        // first method

        // res.add(new ArrayList<Integer>(curr));
        // System.out.println("res"+res);

        // for (int i = start; i < nums.length; i++) {
        //     System.out.println("cur1"+curr+" "+i);
        //     curr.add(nums[i]);
        //     System.out.println("cur2"+curr+" "+i);
        //     bt(i + 1, curr, nums);
        //     curr.remove(curr.size() - 1);
        //     System.out.println("curremove"+curr+" "+i);
        // }

        //2nd method
        if(start==nums.length){
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        curr.add(nums[start]);
        bt(start+1,curr,nums);
        curr.remove(curr.size()-1);
        bt(start+1, curr, nums);


    }
}
