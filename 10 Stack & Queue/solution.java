import java.util.Stack;

public class solution {
    public static void main(String[] args) {
        System.out.println( isValid("()[){}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch==')' || ch=='}' || ch==']'){
                if(ch==')'){
                    if(st.peek()=='('){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(ch=='}'){
                    if(st.peek()=='{'){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(ch==']'){
                    if(st.peek()=='['){
                        st.pop();
                    }else{
                        return false;
                    }
                }
            }else{
                st.push(ch);
            }
        }
        return true;
    }
}