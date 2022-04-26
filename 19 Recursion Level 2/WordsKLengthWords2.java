import java.io.*;
import java.util.*;

public class WordsKLengthWords2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateWords(1,k,new HashSet<>(),ustr,"");
    }

    public static void generateWords(int cs, int ts, HashSet<Character> usedChar,String ustr,String asf) {
        if(cs>ts){
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < ustr.length(); i++) {
            char ch=ustr.charAt(i);
            if(usedChar.contains(ch)==false){
                usedChar.add(ch);
                generateWords(cs+1, ts, usedChar, ustr, asf+ch);
                usedChar.remove(ch);
            }
        }
        
    }

}
