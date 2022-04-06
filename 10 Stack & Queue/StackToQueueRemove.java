import java.util.Stack;

public class StackToQueueRemove {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }

            mainS.push(val);
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.peek();
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }

    }

    public static void main(String[] args) {

    }
}
