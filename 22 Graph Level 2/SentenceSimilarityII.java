// problem link   https://www.lintcode.com/problem/855/
import java.util.HashMap;
import java.util.List;

public class SentenceSimilarityII {
    //words1 = ["great", "acting", "skills"] 
    //words2 = ["fine", "drama", "talent"]
    //pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]
    HashMap<String, String> par;
    HashMap<String, Integer> rank;

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        par = new HashMap<>();
        rank = new HashMap<>();

        if (words1.size() != words2.size()) {
            return false;
        }

        for (List<String> list : pairs) {
            union(list.get(0), list.get(1));
        }

        for (int i = 0; i < words1.size(); i++) {
            String w1 = words1.get(i);
            String w2 = words2.get(i);
            if (w1.equals(w2) == false && find(w1).equals(find(w2)) == false) {
                return false;
            }
        }
        return true;

    }

    public void union(String x, String y) {
        String lx = find(x);
        String ly = find(y);

        if (lx.equals(ly) == false) {
            if (rank.get(lx) > rank.get(ly)) {
                par.put(ly, lx);
            } else if (rank.get(lx) < rank.get(ly)) {
                par.put(lx, ly);
            } else {
                par.put(lx, ly);
                rank.put(lx, rank.get(ly) + 1);
            }
        }
    }

    public String find(String x) {
        if (par.containsKey(x) == false) {
            par.put(x, x);
            rank.put(x, 1);
        }
        if (x.equals(par.get(x))) {
            return x;
        }
        String temp = find(par.get(x));
        par.put(x, temp);
        return temp;
    }
}
