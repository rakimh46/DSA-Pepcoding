import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> degree = new HashMap<>();
        
        if (words == null || words.length == 0){
            return "";
        }
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                degree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            boolean flag = false;
            String curr = words[i];
            String next = words[i + 1];

            int length = Math.min(curr.length(), next.length());

            for (int j = 0; j < length; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);

                if (ch1 != ch2) {
                    HashSet<Character> set = new HashSet<>();
                    if (map.containsKey(ch1) == true) {
                        set = map.get(ch1);
                        if (set.contains(ch2) == false) {
                            set.add(ch2);
                            map.put(ch1, set);
                            degree.put(ch2, degree.get(ch2) + 1);
                        }
                    } else {
                        set.add(ch2);
                        degree.put(ch2, degree.get(ch2) + 1);
                        map.put(ch1, set);
                    }
                    flag = true;
                    break;
                }

            }
            if (flag == false && next.length() < curr.length()) {
                return "";
                
            }
        }

        LinkedList<Character> qu=new LinkedList<>();
        StringBuilder sb=new StringBuilder();

        for (char ch : degree.keySet()) {
            if(degree.get(ch)==0){
                qu.addLast(ch);
            }
        }

        int count=0;
        while(qu.size()>0){
            char ch=qu.removeFirst();
            sb.append(ch);
            count++;

            if(map.containsKey(ch)){
                HashSet<Character> nbrs=map.get(ch);
                for (char nbr : nbrs) {
                    degree.put(nbr, degree.get(nbr)-1);
                    if(degree.get(nbr)==0){
                        qu.add(nbr);
                    }
                } 
            }
        }

        if(count==degree.size()){
            return sb.toString();
        }
        return "";
    }
}
