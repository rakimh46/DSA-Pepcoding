/*
ski value
    A to Z  is 65 to  90
    a to z  is 97 to  122
*/

public class ToggleCase {
    public static void main(String[] args) {
        String str="pepCODinG";
        System.out.println( toggle(str));
    }

    public static String toggle(String str) {

        StringBuilder sb= new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {

            char ch = sb.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char res = (char) ('A' + ch - 'a');
                sb.setCharAt(i, res);
            } else if(ch >= 'A' && ch <= 'Z'){
                char res = (char) ('a' + ch - 'A');
                sb.setCharAt(i, res);
            }

        }
        return sb.toString();
    }
}
