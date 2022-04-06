
/**
 * createStack
 * lifo
 */
import java.util.Stack;

public class StartStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        System.out.println(st.pop());
        st.add(60);
        System.out.println(st);
        
        System.out.println(st.size());
        System.out.println(st.peek());
        
    }
}