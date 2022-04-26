import java.io.*;
import java.util.*;

public class WordsKLengthWords1 {

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

        generateWords(k, 0, new Character[k], 0, ustr);

    }

    public static void generateWords(int ts, int ssf, Character[] spot, int idx, String ustr) {
        if (idx == ustr.length()) {
            if (ssf == ts) {
                for (Character ch : spot) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }
        char ch = ustr.charAt(idx);
        for (int i = 0; i < spot.length; i++) {
            if (spot[i] == null) {
                spot[i] = ch;
                generateWords(ts, ssf + 1, spot, idx + 1, ustr);
                spot[i] = null;
            }
        }
        generateWords(ts, ssf, spot, idx + 1, ustr);
    }

}