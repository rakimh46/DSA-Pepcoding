import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    // leetcode
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] a = new int[26];
        int i = 0, max = 0;
        for (char ch : s.toCharArray()) {
            a[ch - 'a'] = i++;
        }

        i = 0; // prev point
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            max = Math.max(max, a[ch - 'a']);
            if (max == j) {
                ans.add(j - i + 1);
                i = j + 1;
            }
        }

        return ans;
    }

    // pepcoding
    public List<Integer> partitionLabels2(String s) {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int max = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, map.get(s.charAt(i)));

            if (max == i) {
                ans.add(i - prev + 1);
                prev = i + 1;
            }

        }
        return ans;
    }

}
