
/**
 * Postfix Evaluation And Conversions
 * 1st post into Evaluation
 * 2nd post into infix
 * 3rd post into prefix
 */
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String post = "264*8/+3-";

        conversions(post);
    }

    public static void conversions(String post) {
        Stack<Integer> eval = new Stack<Integer>();
        Stack<String> inExp = new Stack<>();
        Stack<String> preExp = new Stack<>();

        for (int i = 0; i < post.length(); i++) {
            char ch = post.charAt(i);

            if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                evaluation(eval, ch);
                infix(inExp, ch);
                prefix(preExp, ch);
            } else {
                eval.push(Integer.parseInt(ch + ""));
                inExp.push(ch+"");
                preExp.push(ch+"");
            }
        }

        System.out.println(eval.pop());
        System.out.println(inExp.pop());
        System.out.println(preExp.pop());
    }

    public static void evaluation(Stack<Integer> eval, char op) {
        int v2 = eval.pop(), v1 = eval.pop();

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
        String v2 = inExp.pop(), v1 = inExp.pop();

        inExp.push('(' + v1 + op + v2 + ')');
    }

    public static void prefix(Stack<String> preExp, char op) {
        String v2 = preExp.pop(), v1 = preExp.pop();
        preExp.push(op + v1 + v2);
    }

}
