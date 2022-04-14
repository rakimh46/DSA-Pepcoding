
/**
 * HighestFrequencyCharacter
 */
import java.util.HashMap;

public class HighestFrequencyCharacter {

    public static void main(String[] args) {

        HashMap<Character, Integer> hm = new HashMap<>();
        String str = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";

        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
            i++;
        }
        // System.out.println(hm);
        int maxfreq = Integer.MIN_VALUE;
        char maxch = ' ';
        for (char ch : hm.keySet()) {
            int freq = hm.get(ch);
            if (freq > maxfreq) {
                maxfreq = freq;
                maxch = ch;
            }
        }
        System.out.println(maxch);
    }
}