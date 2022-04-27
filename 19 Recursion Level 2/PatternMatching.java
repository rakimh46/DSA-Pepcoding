import java.util.*;

public class PatternMatching {

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        // write your code here
        if(pattern.length()==0){
            if(str.length()==0){
                HashSet<Character> set=new HashSet<>();
                for (int i = 0; i < op.length(); i++) {
                    char ch=op.charAt(i);
                    if(set.contains(ch)==false){
                        System.out.print(ch+" -> "+map.get(ch)+", ");
                        set.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }
        char patch=pattern.charAt(0);
        String rop=pattern.substring(1);
        if(map.containsKey(patch)){
            String prevMapping=map.get(patch);
            if(str.length()<prevMapping.length()){
                return;
            }
            String nextMapping=str.substring(0,prevMapping.length());
            if(prevMapping.equals(nextMapping)){
                //System.out.println(prevMapping+"    "+nextMapping);
                String ros=str.substring(prevMapping.length());
                solution(ros, rop, map, op);   
            }else{
                return;
            }
        }else{
            for (int i = 0; i < str.length(); i++) {
                String fp=str.substring(0,i+1);
                String sp=str.substring(i+1);
                map.put(patch, fp);
                solution(sp, rop, map, op);
                map.remove(patch);
            }
        }
        

    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            String pattern = scn.next();
            HashMap<Character, String> map = new HashMap<>();
            solution(str, pattern, map, pattern);
        }
    }
}
