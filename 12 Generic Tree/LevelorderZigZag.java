import java.util.ArrayList;
import java.util.Stack;

public class LevelorderZigZag {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(Integer[] input) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = input[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void levelOrderLinewiseZZ(Node node) {
        // write your code here
        Stack<Node> mainq = new Stack<>();
        Stack<Node> helper = new Stack<>();
        int level = 0;
        mainq.push(node);

        while (mainq.size() > 0) {
            Node frontnode = mainq.pop();
            System.out.print(frontnode.data + " ");

            if (level % 2 == 0) {
                for (int i = 0; i < frontnode.children.size(); i++) {
                    helper.push(frontnode.children.get(i));
                }
            } else {
                for (int i = frontnode.children.size() - 1; i >= 0; i--) {
                    helper.push(frontnode.children.get(i));
                }

            }
            if (mainq.size() == 0) {
                level++;
                System.out.println();
                Stack<Node> temp = mainq;
                mainq = helper;
                helper = temp;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        

        Node root = construct(input);
        levelOrderLinewiseZZ(root);
    }

}