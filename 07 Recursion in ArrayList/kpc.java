import java.util.ArrayList;

public class kpc {
    public static void main(String[] args) {
        String str = "78";
        System.out.println(getKPC(str));
    }

    static String[] keypad = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> res = getKPC(ros);
        int idx = Integer.parseInt(ch + "");
        String word = keypad[idx];
        
        ArrayList<String> mylist = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (String s : res) {
                mylist.add(word.charAt(i) + s);
            }
        }

        return mylist;
    }
}
