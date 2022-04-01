public class toggle {

    public static void main(String[] args) {
        String str = "pepCODinG";
        System.out.println(toggleq(str));
    }

    public static String toggleq(String str) {
        StringBuilder sb = new StringBuilder(str);

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
