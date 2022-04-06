import java.util.Stack;

/**
 * Prefix Evaluation And Conversions
 */
public class PrefixConversions {
    public static void main(String[] args) {
        String str="-+2/*6483";
        conversions(str);
    }
    public static void conversions(String pre) {
        Stack<Integer> eval = new Stack<Integer>();
        Stack<String> inExp = new Stack<>();
        Stack<String> postExp = new Stack<>();

        for (int i = pre.length()-1; i>=0; i--) {
            char ch = pre.charAt(i);

            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                evaluation(eval, ch);
                infix(inExp, ch);
                postfix(postExp, ch);
            } else {
                eval.push(Integer.parseInt(ch + ""));
                inExp.push(ch+"");
                postExp.push(ch+"");
            }
        }

        System.out.println(eval.pop());
        System.out.println(inExp.pop());
        System.out.println(postExp.pop());
    }

    public static void evaluation(Stack<Integer> eval, char op) {
        int v1 = eval.pop(), v2 = eval.pop();

        if (op == '+') {
            eval.push(v1 + v2);
        } else if (op == '-') {
            eval.push(v1 - v2);
        } else if (op == '*') {
            eval.push(v1 * v2);
        } else if (op == '/') {
            eval.push(v1 / v2);
        }
    }

    public static void infix(Stack<String> inExp, char op) {
        String v1 = inExp.pop(), v2 = inExp.pop();

        inExp.push('(' + v1 + op + v2 + ')');
    }

    public static void postfix(Stack<String> postExp, char op) {
        String v1 = postExp.pop(), v2 = postExp.pop();
        postExp.push(v1 + v2+op);
    }
}
