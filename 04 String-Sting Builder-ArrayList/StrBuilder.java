public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("Hello");
        int a=sb.length();

        char b=sb.charAt(0);
        sb.append(" ji");
        sb.append(" World");

        
        sb.insert(2, b);
        
        sb.reverse();
        sb.reverse();
        
        sb.deleteCharAt(2);

        sb.delete(5, 8);

        sb.insert(5, " JI");

        String c=sb.substring(5,10);

        sb.replace(5, 8, " hanji");

        sb.setCharAt(0, 'h');
        System.out.println(sb);
    }
}
