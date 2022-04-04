import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String exp = "3/(6*8-4)+9";
        System.out.println(evaluate(exp));
    }

    public static int evaluate(String exp) {

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                operators.push(ch);
                System.out.println("3  "+operators);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(operators.peek()) >= precedence(ch)) {
                    char op = operators.pop();
                    int v2 = operands.pop(), v1 = operands.pop();

                    if (op == '+')
                        operands.push(v1 + v2);
                    else if (op == '-')
                        operands.push(v1 - v2);
                    else if (op == '*')
                        operands.push(v1 * v2);
                    else if (op == '/')
                        operands.push(v1 / v2);
                        
                }
                operators.push(ch);
                System.out.println("2    "+operands);
                System.out.println("2  +  "+operators);
                
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char op = operators.pop();
                    int v2 = operands.pop(), v1 = operands.pop();

                    if (op == '+')
                        operands.push(v1 + v2);
                    else if (op == '-')
                        operands.push(v1 - v2);
                    else if (op == '*')
                        operands.push(v1 * v2);
                    else if (op == '/')
                        operands.push(v1 / v2);
                }
                operators.pop();

            } else if (ch >= '0' && ch <= '9') {
                operands.push(Integer.parseInt(ch + ""));
                System.out.println("1   "+operands);
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();
            int v2 = operands.pop(), v1 = operands.pop();

            if (op == '+')
                operands.push(v1 + v2);
            else if (op == '-')
                operands.push(v1 - v2);
            else if (op == '*')
                operands.push(v1 * v2);
            else if (op == '/')
                operands.push(v1 / v2);
        }

        return operands.pop();

    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 2;
        } else {
            return 4;
        }
    }

}
