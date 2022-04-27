import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String str="abcd";
        swap(str,0,1);
    }

    public static void swap(String str,int i,int j) {
        HashMap<Character, String> map=new HashMap<>();
        map.put('p', "graph");
        map.put('e', "trees");
        String op="pep";
        for (int k = 0; k < op.length(); k++) {
            char ch=op.charAt(k);
            if(map.containsKey(ch)){
                System.out.print(ch+" -> "+map.get(ch)+", ");
                map.remove(ch);
            }
        }
        // System.out.println(map);

    }
}
