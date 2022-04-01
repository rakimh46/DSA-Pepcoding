import java.util.ArrayList;
import java.util.List;

/**
 * PalindromicSubstrings
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        String str="abcc";
        substring(str);
    }

    public  static boolean isPalindromic(String ss){
        int i=0;
        int j=ss.length()-1;
        while(i<=j){
            char ch1=ss.charAt(i);
            char ch2=ss.charAt(j);
            
            if(ch1==ch2){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void substring(String str) {
        List<String> ans= new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                String ss= str.substring(i, j);
                //System.out.println(ss);
                if(isPalindromic(ss)==true){
                    ans.add(ss);
                }
            }
        }
        System.out.println(ans);
        
    }
}