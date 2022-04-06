import java.util.Stack;

/**
 * 1. You are given an infix expression.
 * 2. You are required to convert it to postfix and print it.
 * 3. You are required to convert it to prefix and print it.
 */
public class InfixConversions {
    public static void main(String[] args) {
        String str = "a*(b-c+d)/e";
        conversions(str);
    }

    public static void conversions(String exp) {
        Stack<String> preExp = new Stack<>();
        Stack<String> postExp = new Stack<>();
        Stack<Character> operators = new Stack<>(); // operators

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch)) {
                    char op = operators.pop();
                    String v2 = postExp.pop(), v1 = postExp.pop();
                    postExp.push(v1 + v2 + op);
                    String a2 = preExp.pop(), a1 = preExp.pop();
                    preExp.push(op + a1 + a2);
                }
                operators.push(ch);

            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char op = operators.pop();
                    String v2 = postExp.pop(), v1 = postExp.pop();
                    postExp.push(v1 + v2 + op);
                    String a2 = preExp.pop(), a1 = preExp.pop();
                    preExp.push(op + a1 + a2);
                }
                operators.pop();

            } else if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                postExp.push(ch + "");
                preExp.push(ch + "");
            }
        }
        while (operators.size() > 0) {
            char op = operators.pop();
            String v2 = postExp.pop(), v1 = postExp.pop();
            postExp.push(v1 + v2 + op);
            String a2 = preExp.pop(), a1 = preExp.pop();
            preExp.push(op + a1 + a2);
        }
        System.out.println(postExp.pop());
        System.out.println(preExp.pop());
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 2;
        } else {
            return 4;
        }
    }
}
