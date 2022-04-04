import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        String exp = "((a+b)+(c+d))";

        System.out.println(Duplicate(exp));
    }

    public static boolean Duplicate(String exp) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }

        }
        return false;
    }

}
