import java.util.ArrayList;

/**
 * Subsequence
 */
public class Subsequence {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subsequence(str));
    }

    public static ArrayList<String> subsequence(String str) {

        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);

        ArrayList<String> res=subsequence(ros);

        ArrayList<String> mylist=new ArrayList<>();

        for (String l : res) {
            mylist.add(l);
            
        } 
        for (String l : res) {
            mylist.add(ch+l);
            
        }
        return mylist;
    }
}