import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "[(a+b)+{(c+d)*(e/f)]}";
        System.out.println(balanced(str));
    }

    public static boolean balanced(String str) {
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch== '['){
                st.push(ch);
            }else if(ch=='}' || ch==')' || ch== ']'){
                if(st.size()==0){
                    return false;
                }
                if((ch==')' && st.peek()!='(') || (ch==']' && st.peek()!='[') || (ch=='}' && st.peek()!='{')){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        if(st.size()>0){
            return false;
        }
        return true;
    }
}
